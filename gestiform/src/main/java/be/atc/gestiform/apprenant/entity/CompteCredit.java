package be.atc.gestiform.apprenant.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class CompteCredit extends AbstractPersistable<Integer>{
	
	private Integer solde;
	
	@OneToOne
	private Apprenant apprenant;

	/**
	 * @return the solde
	 */
	public Integer getSolde() {
		return solde;
	}

	/**
	 * @param solde the solde to set
	 */
	public void setSolde(Integer solde) {
		this.solde = solde;
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
	
	

}
