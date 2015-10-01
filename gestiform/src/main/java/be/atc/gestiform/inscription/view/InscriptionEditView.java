package be.atc.gestiform.inscription.view;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import be.atc.gestiform.apprenant.entity.Apprenant;
import be.atc.gestiform.apprenant.service.ApprenantService;
import be.atc.gestiform.competence.entity.Competence;
import be.atc.gestiform.formation.entity.Formation;
import be.atc.gestiform.inscription.entity.Inscription;
import be.atc.gestiform.inscription.service.InscriptionService;
import be.atc.gestiform.session.entity.Session;
import be.atc.gestiform.session.services.SessionService;
import be.atc.gestiform.util.JsfUtil;

@Component("inscriptionEditView")
@Scope("session")
public class InscriptionEditView {
	
	@Autowired
	ApprenantService apprenantService;
	@Autowired
	InscriptionService inscriptionService;
	@Autowired
	SessionService sessionService;
	@Autowired
	InscriptionListView inscriptionListView;
	
	private Inscription inscription;
	
	public InscriptionEditView() {
		if(inscription == null) {
			inscription = new Inscription();
		}
	}

	/**
	 * @return the session
	 */
	public Session getSession() {
		return inscription.getSession();
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(Session session) {
		inscription.setSession(session);
	}
	
	/**
	 * @return the apprenant
	 */
	public Apprenant getApprenant() {
		return inscription.getApprenant();
	}

	/**
	 * @param apprenant the apprenant to set
	 */
	public void setApprenant(Apprenant apprenant) {
		inscription.setApprenant(apprenant);
	}
	
	/**
	 * return autocomplete suggest list
	 * @param query
	 * @return
	 */
    public List<Apprenant> completeApprenant(String query) {
        //TODO optimize
        Iterable<Apprenant> allApprenants = apprenantService.findAll();
        List<Apprenant> filteredApprenants = new ArrayList<>();
        
        System.out.println("query" + query);
         
        for (Apprenant apprenant : allApprenants) {
        	String nom = apprenant.getNom();
        	String prenom = apprenant.getPrenom();
        	String registreNational = apprenant.getRegistreNational();
        	System.out.println("will compare for complete apprenant " + nom + prenom + registreNational);
			if((nom != null && nom.trim().toLowerCase().startsWith(query))
				|| (prenom != null && prenom.trim().toLowerCase().startsWith(query))
				|| (registreNational != null && registreNational.trim().toLowerCase().startsWith(query))){
				filteredApprenants.add(apprenant);
				System.out.println("add apprenant " + nom + prenom + registreNational);
			}
		}
         
        System.out.println(filteredApprenants.size());
        return filteredApprenants;
    }
    
	public String ajoutInscription(Integer id) {
		if(id == null){
			//TODO message to the UI
			return JsfUtil.FAILURE;
		} 
		this.setSession(sessionService.findOne(id));
		return JsfUtil.SUCCESS;
	}
    
	/**
	 * submit for the form of edited formation
	 * @return navigation
	 */
	public String submit() {
		System.out.println("inscription editing");
		System.out.println("inscription : " + getSession().getDebut() + "-" + getSession().getFin());
		System.out.println("inscription formation : " + getSession().getFormation());
		//get competences of session
		Formation formation = inscription.getSession() .getFormation();
		List<Competence> competencesSession = formation.getCompetences();
		//get competence of apprenant
		Apprenant apprenant = inscription.getApprenant();
		List<Competence> competencesApprenant = apprenant.getCompetences();
		//check if apprenant has competence
		List<Competence> missingCompetences = new ArrayList<>();
		for (Competence competenceSession : competencesSession) {
			if(! competencesApprenant.contains(competenceSession)){
				missingCompetences.add(competenceSession);
			}
		}
		//is not, organize test session
		System.out.println("organize test session");
		//save sessions		
		inscription = inscriptionService.save(inscription);
		System.out.println("inscription : " + inscription.getSession());
		inscriptionListView.setSessionId(inscription.getSession().getId());
		inscription=new Inscription();
		return JsfUtil.SUCCESS;
	}
	
	/**
	 * method called when user want to cancel editing
	 * @return
	 */
	public String cancel() {
		System.out.println("inscription : " + getSession().getDebut() + "-" + getSession().getFin());
		System.out.println("cancel editing");
		inscription=new Inscription();
		return JsfUtil.SUCCESS;
	}

}
