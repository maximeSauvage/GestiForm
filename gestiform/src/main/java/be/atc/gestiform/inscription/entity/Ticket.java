package be.atc.gestiform.inscription.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

import be.atc.gestiform.apprenant.entity.CompteCredit;

@Entity
public class Ticket extends AbstractPersistable<Integer>{

	private boolean paye;
	private boolean rembourse;
	
	@OneToOne(fetch=FetchType.EAGER)
	private Inscription inscription;
	@ManyToOne
	private CompteCredit compteCredit;
	
	/**
	 * @return the paye
	 */
	public boolean isPaye() {
		return paye;
	}
	/**
	 * @param paye the paye to set
	 */
	public void setPaye(boolean paye) {
		this.paye = paye;
	}
	/**
	 * @return the rembourse
	 */
	public boolean isRembourse() {
		return rembourse;
	}
	/**
	 * @param rembourse the rembourse to set
	 */
	public void setRembourse(boolean rembourse) {
		this.rembourse = rembourse;
	}
	/**
	 * @return the inscription
	 */
	public Inscription getInscription() {
		return inscription;
	}
	/**
	 * @param inscription the inscription to set
	 */
	public void setInscription(Inscription inscription) {
		this.inscription = inscription;
	}
	/**
	 * @return the compteCredit
	 */
	public CompteCredit getCompteCredit() {
		return compteCredit;
	}
	/**
	 * @param compteCredit the compteCredit to set
	 */
	public void setCompteCredit(CompteCredit compteCredit) {
		this.compteCredit = compteCredit;
	}
	
	
}
