package be.atc.gestiform.session.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

import be.atc.gestiform.inscription.entity.Inscription;

@Entity
public class TestSession extends AbstractPersistable<Integer> {

	@OneToMany(mappedBy="testSession",fetch=FetchType.EAGER)
	private List<Inscription> inscriptions;
	
	private boolean organisee;
	private Date date;

	/**
	 * @return the inscriptions
	 */
	public List<Inscription> getInscriptions() {
		return inscriptions;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
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
