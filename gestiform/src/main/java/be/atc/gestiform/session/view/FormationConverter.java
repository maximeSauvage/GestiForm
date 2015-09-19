package be.atc.gestiform.session.view;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import be.atc.gestiform.formation.entity.Formation;
import be.atc.gestiform.formation.service.FormationService;

@Component("formationConverter")
public class FormationConverter implements Converter {
	
	@Autowired
	FormationService formationService;
 
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
    	System.out.println("getAsObject : " + value);
        if(value != null && value.trim().length() > 0) {
            try {
            	System.out.println("will try to found formation");
            	Formation formation = formationService.findOne(Integer.parseInt(value));
            	System.out.println("found" + formation);
                return formation;
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
        if(object != null && object instanceof Formation) {
        	System.out.println("get" + ((Formation) object).getId());
            return String.valueOf(((Formation) object).getId());
        }
        else {
            return null;
        }
    }   
} 