package be.atc.gestiform.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JsfUtil {

	public static final String SUCCESS = "success";
	public static final String FAILURE = "";
	
	/**
	 * show message in the UI
	 * @param message 
	 * 
	 */
	 public static void showErrorMessage(String message) {
		FacesContext context = FacesContext.getCurrentInstance();
		 
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,message, message) );
	}
}
