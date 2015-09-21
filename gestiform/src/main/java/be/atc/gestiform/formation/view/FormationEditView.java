package be.atc.gestiform.formation.view;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import be.atc.gestiform.competence.entity.Competence;
import be.atc.gestiform.competence.service.CompetenceService;
import be.atc.gestiform.formation.entity.Formation;
import be.atc.gestiform.formation.service.FormationService;
import be.atc.gestiform.util.JsfUtil;

@Component("formationEditView")
@Scope("session")
public class FormationEditView {
	
	@Autowired
	FormationService formationService;
	@Autowired
	CompetenceService competenceService;
	
	/**
	 * the formation to edit
	 */
	private Formation formation;
	
	public FormationEditView() {
		if(formation ==  null) {
			formation = new Formation();
		}
		if(formation.getCompetences() == null){
			formation.setCompetences(new ArrayList<>());
		}
	}

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
	
	/**
	 * return a list of competences avalaible for autocomplete input
	 * @param query
	 * @return
	 */
	public List<Competence> completeCompetence(String query) {
        //TODO optimize
        Iterable<Competence> allCompetences = competenceService.findAll();
        List<Competence> filteredCompetences = new ArrayList<>();
        
        System.out.println("query" + query);
         
        for (Competence competence : allCompetences) {
			if(competence.getNom().toLowerCase().startsWith(query)){
				filteredCompetences.add(competence);
				System.out.println("add formation " + competence.getNom());
			}
		}
         
        System.out.println(filteredCompetences.size());
        return filteredCompetences;
    }
	
	/**
	 * submit for the form of edited formation
	 * @return navigation
	 */
	public String submit() {
		System.out.println(formation.getNom());
		formation = formationService.save(formation);
		System.out.println(formation.getNom());
		formation=new Formation();
		return JsfUtil.SUCCESS;
	}
	
	/**
	 * method called when user want to cancel editing
	 * @return
	 */
	public String cancel() {
		System.out.println(formation.getNom());
		System.out.println("cancel editing");
		formation=new Formation();
		return JsfUtil.SUCCESS;
	}
}
