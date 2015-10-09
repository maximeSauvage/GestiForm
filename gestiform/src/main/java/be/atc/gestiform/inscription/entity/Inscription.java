package be.atc.gestiform.inscription.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

import be.atc.gestiform.apprenant.entity.Apprenant;
import be.atc.gestiform.session.entity.Session;
import be.atc.gestiform.session.entity.TestSession;

@Entity
public class Inscription extends AbstractPersistable<Integer>{
	
	private Date dateInscription;
	private boolean presenceFormation;
	private boolean hasCompetence;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Apprenant apprenant;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Session session;
	
	@ManyToOne
	private TestSession testSession;
	
//	@OneToOne(mappedBy="inscription",fetch=FetchType.EAGER)
//	private Ticket ticket;
	

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

	/**
	 * @return the hasCompetence
	 */
	public boolean isHasCompetence() {
		return hasCompetence;
	}

	/**
	 * @param hasCompetence the hasCompetence to set
	 */
	public void setHasCompetence(boolean hasCompetence) {
		this.hasCompetence = hasCompetence;
	}

	/**
	 * @return the testSession
	 */
	public TestSession getTestSession() {
		return testSession;
	}

	/**
	 * @param testSession the testSession to set
	 */
	public void setTestSession(TestSession testSession) {
		this.testSession = testSession;
	}

//	/**
//	 * @return the ticket
//	 */
//	public Ticket getTicket() {
//		return ticket;
//	}
//
//	/**
//	 * @param ticket the ticket to set
//	 */
//	public void setTicket(Ticket ticket) {
//		this.ticket = ticket;
//	}

//	/**
//	 * @return the ticket
//	 */
//	public Ticket getTicket() {
//		return ticket;
//	}
//
//	/**
//	 * @param ticket the ticket to set
//	 */
//	public void setTicket(Ticket ticket) {
//		this.ticket = ticket;
//	}
	
}
