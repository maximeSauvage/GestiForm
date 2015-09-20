package be.atc.gestiform.formation.view;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import be.atc.gestiform.competence.entity.Competence;
import be.atc.gestiform.competence.service.CompetenceService;

@Component("competenceConverter")
public class CompetenceConverter implements Converter {
	
	@Autowired
	CompetenceService competenceService;
 
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
    	System.out.println("getAsObject : " + value);
        if(value != null && value.trim().length() > 0) {
            try {
            	System.out.println("will try to found formation");
            	Competence competence = competenceService.findOne(Integer.parseInt(value));
            	System.out.println("found" + competence);
                return competence;
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid Competence."));
            }
        }
        else {
            return null;
        }
    }
 
	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
    	System.out.println("getAsString: " + object);
        if(object != null && object instanceof Competence) {
        	System.out.println("get" + ((Competence) object).getId());
            return String.valueOf(((Competence) object).getId());
        }
        else {
            return null;
        }
    }   
} 