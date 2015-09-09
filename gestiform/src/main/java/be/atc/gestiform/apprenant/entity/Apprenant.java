package be.atc.gestiform.apprenant.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * the entity which represent an "apprenant" , the person who will suscribe to a session
 * @author msauvage
 *
 */
@Entity
public class Apprenant extends AbstractPersistable<Integer> {

	private String nom;
	private String prenom;
	private String rue;
	private String numRue;
	private String telephone;
	private String email;
	private String registreNational;
	
	@ManyToOne
	private Adresse adresse;
	
	public Apprenant() {
	}
	
	/**
	 * @param nom
	 * @param prenom
	 * @param rue
	 * @param numRue
	 * @param telephone
	 * @param email
	 * @param registreNational
	 * @param adresse
	 */
	public Apprenant(String nom, String prenom, String rue, String numRue, String telephone, String email,
			String registreNational, Adresse adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.rue = rue;
		this.numRue = numRue;
		this.telephone = telephone;
		this.email = email;
		this.registreNational = registreNational;
		this.adresse = adresse;
	}

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
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * @return the numRue
	 */
	public String getNumRue() {
		return numRue;
	}

	/**
	 * @param numRue the numRue to set
	 */
	public void setNumRue(String numRue) {
		this.numRue = numRue;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the registreNational
	 */
	public String getRegistreNational() {
		return registreNational;
	}

	/**
	 * @param registreNational the registreNational to set
	 */
	public void setRegistreNational(String registreNational) {
		this.registreNational = registreNational;
	}

	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}