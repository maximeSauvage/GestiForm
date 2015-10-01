package be.atc.gestiform.inscription.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

import be.atc.gestiform.apprenant.entity.Apprenant;
import be.atc.gestiform.session.entity.Session;
import be.atc.gestiform.session.entity.TestSession;

@Entity
public class Inscription extends AbstractPersistable<Integer>{
	
	private Date dateInscription;
	private boolean presenceFormation;
	
	@ManyToOne
	private Apprenant apprenant;
	
	@ManyToOne
	private Session session;
	
	@ManyToOne
	private TestSession testSession;

	/**
	 * @return the dateInscription
	 */
	public Date getDateInscription() {
		return dateInscription;
	}

	/**
	 * @param dateInscription the dateInscription to set
	 */
	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	/**
	 * @return the presenceFormation
	 */
	public boolean isPresenceFormation() {
		return presenceFormation;
	}

	/**
	 * @param presenceFormation the presenceFormation to set
	 */
	public void setPresenceFormation(boolean presenceFormation) {
		this.presenceFormation = presenceFormation;
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
		this.apprenant = apprenant;
	}

	/**
	 * @return the session
	 */
	public Session getSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(Session session) {
		this.session = session;
	}
	
}
