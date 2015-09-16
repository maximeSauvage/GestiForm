package be.atc.gestiform.formation.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

import be.atc.gestiform.session.entity.Session;

/**
 * the entity which represent an "formation" , the training
 * @author msauvage
 *
 */
@Entity
public class Formation extends AbstractPersistable<Integer> {
	
	private String nom;
	private String description;
	private Integer duree;
	private Integer prix;
	private boolean active;
	
	@OneToMany
	private List<Session> session;

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the duree
	 */
	public Integer getDuree() {
		return duree;
	}

	/**
	 * @param duree the duree to set
	 */
	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	/**
	 * @return the prix
	 */
	public Integer getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(Integer prix) {
		this.prix = prix;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

}
