package be.atc.gestiform.session.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import be.atc.gestiform.inscription.view.InscriptionEditView;
import be.atc.gestiform.inscription.view.InscriptionListView;
import be.atc.gestiform.session.entity.Session;
import be.atc.gestiform.session.entity.TestSession;
import be.atc.gestiform.session.services.SessionService;
import be.atc.gestiform.session.services.TestSessionService;
import be.atc.gestiform.util.JsfUtil;

@Component("sessionListView")
@Scope("request")
public class SessionListView {
	
	@Autowired
	SessionService sessionService;
	@Autowired
	SessionEditView sessionEditView;
	@Autowired
	InscriptionEditView inscriptionEditView;
	@Autowired
	InscriptionListView inscriptionListView;
	@Autowired
	TestSessionService testSessionService;
	
	public Iterable<Session> getAllSession() {
		System.out.println("find all");
		return sessionService.findAll();
	}
	
	public Iterable<TestSession> getAllSessionTest() {
		return testSessionService.findAll();
	}
	
	public String editSession(Integer id) {
		if(id == null){
			//TODO message to the UI
			return JsfUtil.FAILURE;
		} 
		sessionEditView.setSession(sessionService.findOne(id));
		return JsfUtil.SUCCESS;
	}
	
	public String showInscriptionSessionTest(Integer id) {
		if(id == null){
			//TODO message to the UI
			return JsfUtil.FAILURE;
		} 
		inscriptionListView.setSessionTest(id);
		return JsfUtil.SUCCESS;
	}
	
	public String gererInscription(Integer id) {
		if(id == null){
			//TODO message to the UI
			return JsfUtil.FAILURE;
		} 
		inscriptionListView.setSessionId(id);
		return JsfUtil.SUCCESS;
	}
	
}
