package be.atc.gestiform.apprenant.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import be.atc.gestiform.apprenant.entity.Apprenant;
import be.atc.gestiform.apprenant.service.ApprenantService;

@Component("apprenantListView")
@Scope("request")
public class ApprenantListView {
	
	@Autowired
	ApprenantService apprenantService;
	
	public Iterable<Apprenant> getAllApprenant() {
		return apprenantService.findAllApprenant();
	}
	
	public String editAprennant() {
		return "success";
	}

}
