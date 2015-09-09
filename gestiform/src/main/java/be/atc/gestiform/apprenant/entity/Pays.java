package be.atc.gestiform.apprenant.entity;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * a land
 * @author msauvage
 *
 */
@Entity
public class Pays extends AbstractPersistable<Integer> {
	
	private String pays;
	
	public Pays() {
	}
	
	/**
	 * @param pays
	 */
	public Pays(String pays) {
		super();
		this.pays = pays;
	}

	/**
	 * @return the pays
	 */
	public String getPays() {
		return pays;
	}

	/**
	 * @param pays the pays to set
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}

}
