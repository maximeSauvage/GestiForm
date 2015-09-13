package be.atc.gestiform.apprenant.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import be.atc.gestiform.apprenant.entity.Apprenant;
import be.atc.gestiform.apprenant.service.ApprenantService;
import be.atc.gestiform.util.JsfUtil;

@Component("apprenantListView")
@Scope("request")
public class ApprenantListView {
	
	
	@Autowired
	ApprenantService apprenantService;
	@Autowired
	ApprenantEditView apprenantEditView;
	
	public Iterable<Apprenant> getAllApprenant() {
		System.out.println("find all");
		return apprenantService.findAllApprenant();
	}
	
	public String editAprennant(Integer id) {
		if(id == null){
			//TODO message to the UI
			return JsfUtil.FAILED;
		} 
		apprenantEditView.setApprenant(apprenantService.findOne(id));
		return JsfUtil.SUCCESS;
	}

}
