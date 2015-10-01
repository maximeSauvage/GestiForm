package be.atc.gestiform.inscription.view;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import be.atc.gestiform.apprenant.entity.Apprenant;
import be.atc.gestiform.apprenant.service.ApprenantService;

@Component("apprenantConverter")
public class ApprenantConverter implements Converter {

	@Autowired
	ApprenantService apprenantService;
 
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
    	System.out.println("getAsObject : " + value);
        if(value != null && value.trim().length() > 0) {
            try {
            	System.out.println("will try to found formation");
            	Apprenant apprenant = apprenantService.findOne(Integer.parseInt(value));
            	System.out.println("found" + apprenant);
                return apprenant;
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }
    }
 
	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
    	System.out.println("getAsString: " + object);
        if(object != null && object instanceof Apprenant) {
        	System.out.println("get" + ((Apprenant) object).getId());
            return String.valueOf(((Apprenant) object).getId());
        }
        else {
            return null;
        }
    }  
}
