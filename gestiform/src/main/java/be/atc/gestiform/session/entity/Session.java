package be.atc.gestiform.session.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

import be.atc.gestiform.formation.entity.Formation;

@Entity
public class Session extends AbstractPersistable<Integer>{
	
	@ManyToOne
	private Formation formation;
	
	private Date debut;
	private Date fin;
	private Integer nb_max_apprenant;
	private boolean organisee;
	/**
	 * @return the formation
	 */
	public Formation getFormation() {
		return formation;
	}
	/**
	 * @param formation the formation to set
	 */
	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	/**
	 * @return the debut
	 */
	public Date getDebut() {
		return debut;
	}
	/**
	 * @param debut the debut to set
	 */
	public void setDebut(Date debut) {
		this.debut = debut;
	}
	/**
	 * @return the fin
	 */
	public Date getFin() {
		return fin;
	}
	/**
	 * @param fin the fin to set
	 */
	public void setFin(Date fin) {
		this.fin = fin;
	}
	/**
	 * @return the nb_max_apprenant
	 */
	public Integer getNb_max_apprenant() {
		return nb_max_apprenant;
	}
	/**
	 * @param nb_max_apprenant the nb_max_apprenant to set
	 */
	public void setNb_max_apprenant(Integer nb_max_apprenant) {
		this.nb_max_apprenant = nb_max_apprenant;
	}
	/**
	 * @return the organisee
	 */
	public boolean isOrganisee() {
		return organisee;
	}
	/**
	 * @param organisee the organisee to set
	 */
	public void setOrganisee(boolean organisee) {
		this.organisee = organisee;
	}
	
	
	

}
