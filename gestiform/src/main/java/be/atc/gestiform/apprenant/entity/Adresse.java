package be.atc.gestiform.apprenant.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * an address of a person
 * @author msauvage
 *
 */
@Entity
public class Adresse extends AbstractPersistable<Integer> {
	
	private String codePostal;
	private String localite;
	@ManyToOne(fetch=FetchType.EAGER)
	private Pays pays;
	
	public Adresse() {
	}
	
	
	/**
	 * @param codePostal
	 * @param localite
	 * @param pays
	 */
	public Adresse(String codePostal, String localite, Pays pays) {
		super();
		this.codePostal = codePostal;
		this.localite = localite;
		this.pays = pays;
	}
	/**
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}
	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	/**
	 * @return the localite
	 */
	public String getLocalite() {
		return localite;
	}
	/**
	 * @param localite the localite to set
	 */
	public void setLocalite(String localite) {
		this.localite = localite;
	}
	/**
	 * @return the pays
	 */
	public Pays getPays() {
		return pays;
	}
	/**
	 * @param pays the pays to set
	 */
	public void setPays(Pays pays) {
		this.pays = pays;
	}

}
