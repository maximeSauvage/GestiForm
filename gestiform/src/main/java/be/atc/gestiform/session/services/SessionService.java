package be.atc.gestiform.session.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.atc.gestiform.common.services.BaseService;
import be.atc.gestiform.inscription.entity.Inscription;
import be.atc.gestiform.inscription.service.TicketService;
import be.atc.gestiform.session.entity.Session;
import be.atc.gestiform.session.repository.SessionRepository;

@Service
public class SessionService implements BaseService<Session>{

	@Autowired
	SessionRepository sessionRepository;
	@Autowired
	TicketService ticketService;

	/**
	 * Retrieves a session by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the session with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public Session findOne(Integer formationId) {
		return sessionRepository.findOne(formationId);
	}

	/**
	 * find all session in DB
	 * @return
	 */
	public Iterable<Session> findAll() {
		return sessionRepository.findAll();
	}

	/**
	 * save new or update existing session
	 * @param formation
	 * @return
	 */
	public Session save(Session session) {
		return sessionRepository.save(session);
	}

	/**
	 * organise les sessions qui ont 50% d'élè!ve inscrit 15J avant le début
	 */
	public void organizeSession() {
		System.out.println("organizeSession()");
		Iterable<Session> sessions = findAll();
		for (Session session : sessions) {
			System.out.println("session " + session.getDebut());
			LocalDate dateDebut = LocalDateTime.ofInstant(session.getDebut().toInstant(), ZoneId.systemDefault()).toLocalDate();
			if(session.getDebut().after(new Date()) && dateDebut.minusDays(15).isAfter(LocalDate.now())) {
				
				System.out.println("session is in future but we are min 15d before beginning");
				
				if (session.getInscriptions().size() >= session.getNbMaxApprenant()/2) {
					System.out.println("session has min participant");
					session.setOrganisee(true);
				} else {
					System.out.println("session has not min participant");
					session.setOrganisee(false);
				}
				
				save(session);
				
			} else if (session.getDebut().after(new Date()) && dateDebut.minusDays(15).isBefore(LocalDate.now())) {
				
				if( ! session.isOrganisee()) {
					for(Inscription inscription : session.getInscriptions()) {
						ticketService.reimburseTicket(inscription);
					}
					
				}
				
			}
		}
		
	}
}
