package be.atc.gestiform.session.view;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.context.Theme;

import be.atc.gestiform.formation.entity.Formation;
import be.atc.gestiform.formation.service.FormationService;
import be.atc.gestiform.session.services.SessionService;

@Component("formationConverter")
public class FormationConverter implements Converter {
	
	@Autowired
	FormationService formationService;
 
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
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
        if(object != null && object instanceof Formation) {
        	System.out.println("get" + ((Formation) object).getId());
            return String.valueOf(((Formation) object).getId());
        }
        else {
            return null;
        }
    }   
} 