package be.atc.gestiform.inscription.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.atc.gestiform.apprenant.entity.CompteCredit;
import be.atc.gestiform.apprenant.service.ApprenantService;
import be.atc.gestiform.common.services.BaseService;
import be.atc.gestiform.inscription.entity.Inscription;
import be.atc.gestiform.inscription.entity.Ticket;
import be.atc.gestiform.inscription.repository.TicketRepository;

@Service
public class TicketService implements BaseService<Ticket>{

	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	ApprenantService apprenantService;
	
	@Override
	public Ticket findOne(Integer entityId) {
		return ticketRepository.findOne(entityId);
	}

	@Override
	public Iterable<Ticket> findAll() {
		return ticketRepository.findAll();
	}

	@Override
	public Ticket save(Ticket entity) {
		return ticketRepository.save(entity);
	}

	public Ticket findByInscriptionId(Integer inscriptionId) {
		return ticketRepository.findByInscription_Id(inscriptionId);
		
	}
	/**
	 * generate a ticket from an inscription
	 * check if new solde still positif and debite the comptecredit of the apprenant
	 * @param inscription
	 * @throws IllegalArgumentException if newSolde is negative
	 * @return
	 */
	public Ticket generateTicket(Inscription inscription) {
		System.out.println("generateTicket(Inscription inscription)");
		if( ! assertNewSoldePositif(inscription)){
			throw new IllegalArgumentException("new solde cannot be negative");
		}
		Ticket newTicket = new Ticket();
		newTicket.setInscription(inscription);
		
		CompteCredit compteCredit = inscription.getApprenant().getCompteCredit();
		compteCredit.setSolde(getNewSolde(inscription));
		inscription.getApprenant().setCompteCredit(compteCredit);
		
		apprenantService.save(inscription.getApprenant());
		
		newTicket.setCompteCredit(compteCredit);
		
		newTicket.setPaye(true);
		
		return save(newTicket);
		
	}
	
	/**
	 * calculate new solde of the apprenant
	 * @param inscription
	 * @return
	 */
	public int getNewSolde(Inscription inscription) {
		System.out.println("getNewSolde(Inscription inscription)");
		int newSolde = inscription.getApprenant().getCompteCredit().getSolde();
		System.out.println("old solde " + newSolde);
		newSolde-= inscription.getSession().getFormation().getPrix();
		System.out.println("new solde " + newSolde);
		return newSolde;
	}
	
	/**
	 * check if the new solde can be positive or negative
	 * @param inscription
	 * @return true if new solde is positive
	 */
	public boolean assertNewSoldePositif(Inscription inscription) {
		System.out.println("assertNewSoldePositif(Inscription inscription)");
		return (getNewSolde(inscription) >= 0);
	}

	public Ticket reimburseTicket(Inscription inscription) {
		Ticket resultTicket = findByInscriptionId(inscription.getId());
		
		if(resultTicket.isRembourse()) { return resultTicket;}
		
		
		int newSolde = inscription.getApprenant().getCompteCredit().getSolde();
		newSolde += inscription.getSession().getFormation().getPrix();
		
		CompteCredit compteCredit = inscription.getApprenant().getCompteCredit();
		compteCredit.setSolde(newSolde);
		inscription.getApprenant().setCompteCredit(compteCredit);
		
		apprenantService.save(inscription.getApprenant());
		
		resultTicket.setCompteCredit(compteCredit);
		
		resultTicket.setPaye(true);
		
		return save(resultTicket);
		
	}

}
