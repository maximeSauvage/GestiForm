package be.atc.gestiform.session.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import be.atc.gestiform.common.services.BaseService;
import be.atc.gestiform.session.entity.TestSession;
import be.atc.gestiform.session.repository.TestSessionRepository;
import be.atc.gestiform.util.WeekendQuery;

@Service
public class TestSessionService implements BaseService<TestSession> {
	
	@Autowired
	TestSessionRepository testSessionRepository;
	
	@Value("${gestiform.daysBetweenTestSession}")
	private String daysBetweenTestSession;
	@Value("${gestiform.FirstTestSessionDate}")
	private String FirstTestSessionDate;
	@Value("${gestiform.MinDaysBetweenTestandSession}")
	private String DaysBetweenTestAndSession;
	@Value("${gestiform.MaxParticantsTestSession}")
	private String maxParticantsTestSession;
	@Value("${gestiform.MinParticantsTestSession}")
	private String minParticantsTestSession;
	
	/**
	 * create a sessionTest for every date correponding to param (daysBetweenTestSession and opened days)
	 */
	public void initTestSessionDates(){
		
		List<LocalDate> testSessionDates = new ArrayList<>();
		
		////prendre première date et interval
		int daysBetweenSessions = Integer.parseInt(daysBetweenTestSession);
		LocalDate FirstTestSession = LocalDate.parse(FirstTestSessionDate, DateTimeFormatter.BASIC_ISO_DATE);
		
		////boucle tous les X jours sur la date
		LocalDate limitDate = FirstTestSession.with(TemporalAdjusters.firstDayOfYear()).plusYears(1);
		for (LocalDate currentDate = FirstTestSession; currentDate.isBefore(limitDate); currentDate = currentDate.plusDays(daysBetweenSessions)) {
		    // Do your job here with `date`.
		    System.out.println(currentDate);
		    System.out.println(currentDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.FRENCH));
		    LocalDate temp = currentDate;
			//si jour non ouvrable prendre jour après
		    while (temp.query(new WeekendQuery())) {
				temp = temp.plusDays(1);
				System.out.println("temp weekend loop date" + temp);
				System.out.println(temp.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.FRENCH));
			}
		    System.out.println("final date" + temp);
		    
		    testSessionDates.add(temp);
		}
		
		System.out.println("daysBetweenTestSession" + daysBetweenTestSession);
		System.out.println("daysBetweenTestSession" + daysBetweenSessions);
		System.out.println("FirstTestSessionDate" + FirstTestSessionDate);
		System.out.println("FirstTestSessionDate" + FirstTestSession);
		
		//sauvegarder liste des date
		for (LocalDate testSessionDate : testSessionDates) {
			System.out.println("test session date " + testSessionDate);
			Instant instant = testSessionDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
			Date sessionDate = Date.from(instant);
			TestSession testSession = new TestSession();
			testSession.setDate(sessionDate);
			save(testSession);
			System.out.println("session date " + sessionDate);
			
		}
	}
	
	/**
	 * check every test session in future if they had required participant
	 */
	public void organizeSession(){
		System.out.println("organizeSession()");
		int minPariticipant = Integer.parseInt(minParticantsTestSession);
		Iterable<TestSession> testSessions = findAllByOrderByDateAsc();
		for (TestSession testSession : testSessions) {
			System.out.println("testSession " + testSession.getDate());
			if(testSession.getDate().after(new Date()) ) {
				
				System.out.println("testSession is in future");
				
				if (testSession.getInscriptions().size() >= minPariticipant) {
					System.out.println("testSession has min participant");
					testSession.setOrganisee(true);
				} else {
					System.out.println("testSession has not min participant");
					testSession.setOrganisee(false);
				}
				
				save(testSession);
				
			}
		}
	}
	
	
	
	/**
	 * trouve la prochaine session de test avec des places libres avant la session donnée en paramètre
	 * @param SessionId l'id de la session 
	 * @param DaysBeforeSession le nombre de jour entre la sesison de test et la session
	 * @return
	 */
	public TestSession FindNextNotFullTestSessionBeforeSession(Integer SessionId){
		int maxParticants = Integer.parseInt(maxParticantsTestSession);
		Iterable<TestSession> testSessions = findAllByOrderByDateAsc();
		for (TestSession testSession : testSessions) {
			if(testSession.getDate().after(new Date()) && testSession.getInscriptions().size() <= maxParticants) {
				return testSession;
			}
		}
		return null;
	}

	@Override
	public TestSession findOne(Integer entityId) {
		return testSessionRepository.findOne(entityId);
	}

	@Override
	public Iterable<TestSession> findAll() {
		return testSessionRepository.findAll();
	}
	
	public Iterable<TestSession> findAllByOrderByDateAsc() {
		return testSessionRepository.findAllByOrderByDateAsc();
	}

	@Override
	public TestSession save(TestSession entity) {
		return testSessionRepository.save(entity);
	}


}
