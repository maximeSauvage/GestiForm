package be.atc.gestiform.competence.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import be.atc.gestiform.competence.entity.Competence;
import be.atc.gestiform.competence.service.CompetenceService;
import be.atc.gestiform.util.JsfUtil;

@Component("competenceListView")
@Scope("request")
public class CompetenceListView {

	@Autowired
	CompetenceService competenceService;
	@Autowired
	CompetenceEditView competenceEditView;
	
	public Iterable<Competence> getAllCompetence() {
		System.out.println("find all");
		return competenceService.findAll();
	}
	
	public String editCompetence(Integer id) {
		if(id == null){
			//TODO message to the UI
			return JsfUtil.FAILURE;
		} 
		competenceEditView.setCompetence(competenceService.findOne(id));
		return JsfUtil.SUCCESS;
	}
}
