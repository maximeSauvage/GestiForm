package be.atc.gestiform.session.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import be.atc.gestiform.formation.view.FormationEditView;
import be.atc.gestiform.session.entity.Session;
import be.atc.gestiform.session.services.SessionService;
import be.atc.gestiform.util.JsfUtil;

@Component("sessionListView")
@Scope("request")
public class SessionListView {
	
	@Autowired
	SessionService sessionService;
	@Autowired
	FormationEditView formationEditView;
	
	public Iterable<Session> getAllSession() {
		System.out.println("find all");
		return sessionService.findAll();
	}
	
	public String editFormation(Integer id) {
//		if(id == null){
//			//TODO message to the UI
//			return JsfUtil.FAILURE;
//		} 
//		formationEditView.setFormation(sessionService.findOne(id));
		return JsfUtil.SUCCESS;
	}

}
