package be.atc.gestiform.competence.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import be.atc.gestiform.apprenant.entity.Apprenant;
import be.atc.gestiform.competence.entity.Competence;
import be.atc.gestiform.competence.service.CompetenceService;
import be.atc.gestiform.util.JsfUtil;

@Component("competenceEditView")
@Scope("session")
public class CompetenceEditView {
	
	@Autowired
	CompetenceService competenceService;

	private Competence competence;

	public CompetenceEditView() {
		if (competence == null) {
			competence = new Competence();
		}
	}

	/**
	 * @return the competence
	 */
	public Competence getCompetence() {
		return competence;
	}

	/**
	 * @param apprenant the competence to set
	 */
	public void setCompetence(Competence competence) {
		this.competence = competence;
	}

	public String submit() {
		System.out.println(competence.getNom());
		competence = competenceService.save(competence);
		System.out.println(competence.getNom());
		competence=new Competence();
		return JsfUtil.SUCCESS;
	}

}
