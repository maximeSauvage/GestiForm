package be.atc.gestiform.apprenant.view;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("apprenantEditView")
@Scope("session")
public class ApprenantEditView {
	
	private String hello="";

	/**
	 * @return the hello
	 */
	public String getHello() {
		return hello;
	}

	/**
	 * @param hello the hello to set
	 */
	public void setHello(String hello) {
		this.hello = hello;
	}

}
