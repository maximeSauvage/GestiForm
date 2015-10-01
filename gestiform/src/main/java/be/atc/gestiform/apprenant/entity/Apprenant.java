package be.atc.gestiform.apprenant.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

import be.atc.gestiform.competence.entity.Competence;

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
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Adresse adresse;
	
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Competence> competences;
	
	@OneToOne(mappedBy="apprenant")
	private CompteCredit compteCredit;
	
	
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

	/**
	 * @return the competences
	 */
	public List<Competence> getCompetences() {
		return competences;
	}

	/**
	 * @param competences the competences to set
	 */
	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
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
