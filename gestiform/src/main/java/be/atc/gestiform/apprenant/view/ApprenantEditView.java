package be.atc.gestiform.apprenant.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import be.atc.gestiform.apprenant.entity.Adresse;
import be.atc.gestiform.apprenant.entity.Apprenant;
import be.atc.gestiform.apprenant.entity.Pays;
import be.atc.gestiform.apprenant.service.ApprenantService;
import be.atc.gestiform.util.JsfUtil;

@Component("apprenantEditView")
@Scope("session")
public class ApprenantEditView {

	@Autowired
	ApprenantService apprenantService;

	private Apprenant apprenant;

	public ApprenantEditView() {
		if (apprenant == null) {
			apprenant = new Apprenant();
		}
		if (apprenant.getAdresse() == null) {
			apprenant.setAdresse(new Adresse());
		}
		if (apprenant.getAdresse().getPays() == null) {
			Adresse adresse = apprenant.getAdresse();
			adresse.setPays(new Pays());
			apprenant.setAdresse(adresse);
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
	}

	public String submit() {
		System.out.println(apprenant.getNom());
		apprenant = apprenantService.save(apprenant);
		System.out.println(apprenant.getNom());
		return JsfUtil.SUCCESS;
	}

}
