package be.atc.gestiform.formation.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import be.atc.gestiform.formation.entity.Formation;
import be.atc.gestiform.formation.service.FormationService;
import be.atc.gestiform.util.JsfUtil;

@Component("formationEditView")
@Scope("session")
public class FormationEditView {
	
	@Autowired
	FormationService formationService;
	
	/**
	 * the formation to edit
	 */
	private Formation formation;
	
	

	/**
	 * @return the formation
	 */
	public Formation getFormation() {
		return formation;
	}

	/**
	 * @param formation the formation to set
	 */
	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	
	public FormationEditView() {
		if(formation ==  null) {
			formation = new Formation();
		}
	}
	
	/**
	 * submit for the form of edited formation
	 * @return navigation
	 */
	public String submit() {
		System.out.println(formation.getNom());
		formation = formationService.save(formation);
		System.out.println(formation.getNom());
		return JsfUtil.SUCCESS;
	}
}
