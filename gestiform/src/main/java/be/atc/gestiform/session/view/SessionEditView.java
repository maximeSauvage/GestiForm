package be.atc.gestiform.session.view;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import be.atc.gestiform.competence.entity.Competence;
import be.atc.gestiform.formation.entity.Formation;
import be.atc.gestiform.formation.service.FormationService;
import be.atc.gestiform.session.entity.Session;
import be.atc.gestiform.session.entity.TestSession;
import be.atc.gestiform.session.services.SessionService;
import be.atc.gestiform.util.JsfUtil;

@Component("sessionEditView")
@Scope("session")
public class SessionEditView {
	
	@Autowired
	SessionService SessionService;
	@Autowired
	FormationService formationService;
	
	/**
	 * the formation to edit
	 */
	private Session session;
	
	private TestSession testSession;


	public SessionEditView() {
		initSession();
	}
	
	private void initSession(){
		if(session ==  null) {
			session = new Session();
		}
	}
	
	/**
	 * @return the session
	 */
	public Session getSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(Session session) {
		this.session = session;
	}
	
	/**
	 * return autocomplete suggest list
	 * @param query
	 * @return
	 */
    public List<Formation> completeFormation(String query) {
        //TODO optimize
        Iterable<Formation> allFormations = formationService.findAll();
        List<Formation> filteredFormations = new ArrayList<>();
        
        System.out.println("query" + query);
         
        for (Formation formation : allFormations) {
			if(formation.isActive() && formation.getNom().toLowerCase().startsWith(query)){
				filteredFormations.add(formation);
				System.out.println("add formation " + formation.getNom());
			}
		}
         
        System.out.println(filteredFormations.size());
        return filteredFormations;
    }

	/**
	 * submit for the form of edited formation
	 * @return navigation
	 */
	public String submit() {
		System.out.println("session : " + session.getDebut() + "-" + session.getFin());
		System.out.println("session formation : " + session.getFormation());
		

		session = SessionService.save(session);
		System.out.println("session : " + session);
		session=new Session();
		return JsfUtil.SUCCESS;
	}
	
	/**
	 * method called when user want to cancel editing
	 * @return
	 */
	public String cancel() {
		System.out.println("session : " + session.getDebut() + "-" + session.getFin());
		System.out.println("cancel editing");
		session=new Session();
		return JsfUtil.SUCCESS;
	}

}
