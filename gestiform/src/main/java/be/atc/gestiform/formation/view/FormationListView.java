package be.atc.gestiform.formation.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import be.atc.gestiform.apprenant.entity.Apprenant;
import be.atc.gestiform.formation.entity.Formation;
import be.atc.gestiform.formation.service.FormationService;
import be.atc.gestiform.util.JsfUtil;

@Component("formationListView")
@Scope("request")
public class FormationListView {
	
	
	@Autowired
	FormationService formationService;
	@Autowired
	FormationEditView formationEditView;
	
	public Iterable<Formation> getAllFormation() {
		System.out.println("find all");
		return formationService.findAllFormation();
	}
	
	public String editFormation(Integer id) {
		if(id == null){
			//TODO message to the UI
			return JsfUtil.FAILURE;
		} 
		formationEditView.setFormation(formationService.findOne(id));
		return JsfUtil.SUCCESS;
	}

}
