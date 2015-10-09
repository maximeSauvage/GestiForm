package be.atc.gestiform.session.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

import be.atc.gestiform.formation.entity.Formation;
import be.atc.gestiform.inscription.entity.Inscription;

@Entity
public class Session extends AbstractPersistable<Integer> {
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Formation formation;
	
	@OneToMany(mappedBy="session",fetch=FetchType.EAGER)
	private List<Inscription> inscriptions;
	
	private Date debut;
	private Date fin;
	private Integer nbMaxApprenant;
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
	public Integer getNbMaxApprenant() {
		return nbMaxApprenant;
	}
	/**
	 * @param nb_max_apprenant the nb_max_apprenant to set
	 */
	public void setNbMaxApprenant(Integer nb_max_apprenant) {
		this.nbMaxApprenant = nb_max_apprenant;
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
	/**
	 * @return the inscriptions
	 */
	public List<Inscription> getInscriptions() {
		return inscriptions;
	}

}
