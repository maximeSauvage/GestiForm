package be.atc.gestiform.inscription.repository;

import org.springframework.data.repository.CrudRepository;

import be.atc.gestiform.inscription.entity.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {
	
	public Ticket findByInscription_Id(Integer id);

}
