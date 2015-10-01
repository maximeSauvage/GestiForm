package be.atc.gestiform.inscription.view;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import be.atc.gestiform.apprenant.service.ApprenantService;
import be.atc.gestiform.inscription.entity.Inscription;
import be.atc.gestiform.inscription.service.InscriptionService;
import be.atc.gestiform.session.entity.Session;
import be.atc.gestiform.session.services.SessionService;
import be.atc.gestiform.util.JsfUtil;

@Component("inscriptionListView")
@Scope("session")
public class InscriptionListView {

	@Autowired
	ApprenantService apprenantService;
	@Autowired
	InscriptionService inscriptionService;
	@Autowired
	SessionService sessionService;
	
	private Integer sessionId;

	/**
	 * @return the session
	 */
	public Session getSession() {
		return sessionService.findOne(sessionId);
	}

	/**
	 * @param id the sessionId to set
	 */
	public void setSessionId(Integer id) {
		this.sessionId = id;
	}

	/**
	 * @return the inscriptions
	 */
	public List<Inscription> getInscriptions() {
		return inscriptionService.findBySession_Id(sessionId);
	}
	
	/**
	 * remove inscription form db
	 * @param id
	 */
	public String deleteInscription(Integer id) {
		inscriptionService.delete(id);
		return JsfUtil.SUCCESS;
	}

}
