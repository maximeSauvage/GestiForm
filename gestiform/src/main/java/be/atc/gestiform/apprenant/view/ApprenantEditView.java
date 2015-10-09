package be.atc.gestiform.apprenant.view;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import be.atc.gestiform.apprenant.entity.Adresse;
import be.atc.gestiform.apprenant.entity.Apprenant;
import be.atc.gestiform.apprenant.entity.CompteCredit;
import be.atc.gestiform.apprenant.entity.Pays;
import be.atc.gestiform.apprenant.service.ApprenantService;
import be.atc.gestiform.competence.entity.Competence;
import be.atc.gestiform.competence.service.CompetenceService;
import be.atc.gestiform.util.JsfUtil;

@Component("apprenantEditView")
@Scope("session")
public class ApprenantEditView {

	@Autowired
	ApprenantService apprenantService;
	@Autowired
	CompetenceService competenceService;

	private Apprenant apprenant;

	public ApprenantEditView() {
		init();
	}

	/**
	 * init the member apprenant
	 */
	private void init() {
		if (apprenant == null) {
			System.out.println("init apprenant");
			apprenant = new Apprenant();
		}
		if (apprenant.getAdresse() == null) {
			System.out.println("init adresse");
			apprenant.setAdresse(new Adresse());
		}
		if (apprenant.getAdresse().getPays() == null) {
			System.out.println("init pays");
			Adresse adresse = apprenant.getAdresse();
			adresse.setPays(new Pays());
			apprenant.setAdresse(adresse);
		}
		if (apprenant.getCompteCredit() == null) {
			System.out.println("init compte credit");
			apprenant.setCompteCredit(new CompteCredit());
		}
	}

	/**
	 * @return the apprenant
	 */
	public Apprenant getApprenant() {
		return apprenant;
	}

	/**
	 * @param apprenant the apprenant to set
	 */
	public void setApprenant(Apprenant apprenant) {
		if (apprenant.getAdresse() == null) {
			apprenant.setAdresse(new Adresse());
		}
		if (apprenant.getAdresse().getPays() == null) {
			Adresse adresse = apprenant.getAdresse();
			adresse.setPays(new Pays());
			apprenant.setAdresse(adresse);
		}
		this.apprenant = apprenant;
		init();
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
		System.out.println(apprenant.getNom());
		if(! apprenant.isNew()) {
			Apprenant oldApprenant = apprenantService.findOne(apprenant.getId());
			if(oldApprenant.getCompteCredit().getSolde() > apprenant.getCompteCredit().getSolde()) {
				JsfUtil.showErrorMessage("le nouveau solde doit être supérieur au solde précédent");
				return JsfUtil.FAILURE;
			}
		}
		
		apprenant = apprenantService.save(apprenant);
		System.out.println(apprenant.getNom());
		apprenant = new Apprenant();
		return JsfUtil.SUCCESS;
	}
	
	/**
	 * method called when user want to cancel editing
	 * @return
	 */
	public String cancel() {
		System.out.println(apprenant.getNom());
		System.out.println("cancel editing");
		apprenant = null;
		init();
		return JsfUtil.SUCCESS;
	}

}
