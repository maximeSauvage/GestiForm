package be.atc.gestiform.apprenant.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import be.atc.gestiform.apprenant.entity.Apprenant;
import be.atc.gestiform.apprenant.service.ApprenantService;

@Component("apprenantEditView")
@Scope("session")
public class ApprenantEditView {
	
	
	@Autowired
	ApprenantService apprenantService;
	
	private Apprenant apprenant;
	
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
		this.apprenant = apprenant;
	}
	
	public String getNom() {
		return apprenant.getNom();
	}
	
	public void setNom(String nom) {
		apprenant.setNom(nom);
	}


	public String submit(){
		System.out.println(apprenant.getNom());
		apprenant = apprenantService.save(apprenant);
		System.out.println(apprenant.getNom());
        return "";
	}

}
