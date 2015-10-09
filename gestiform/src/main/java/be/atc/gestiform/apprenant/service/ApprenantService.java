package be.atc.gestiform.apprenant.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.atc.gestiform.apprenant.entity.Adresse;
import be.atc.gestiform.apprenant.entity.Apprenant;
import be.atc.gestiform.apprenant.entity.CompteCredit;
import be.atc.gestiform.apprenant.entity.Pays;
import be.atc.gestiform.apprenant.repository.AdresseRepository;
import be.atc.gestiform.apprenant.repository.ApprenantRepository;
import be.atc.gestiform.apprenant.repository.CompteCreditRepository;
import be.atc.gestiform.apprenant.repository.PaysRepository;
import be.atc.gestiform.common.services.BaseService;

@Service
public class ApprenantService implements BaseService<Apprenant>{
	
	@Autowired
	ApprenantRepository apprenantRepository;
	@Autowired
	AdresseRepository adresseRepository;
	@Autowired
	PaysRepository paysRepository;
	@Autowired
	CompteCreditRepository compteCreditRepository;
	
	public Iterable<Apprenant> findAll() {
		
		return apprenantRepository.findAll();
	}
	
	/**
	 * Retrieves an apprenant by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the apprenant with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public Apprenant findOne(Integer id) {
		return apprenantRepository.findOne(id);
	}
	
	public Apprenant save(Apprenant apprenant) {

		Apprenant result = apprenant;
		Adresse adresse = result.getAdresse();
		Pays pays = adresse.getPays();
		CompteCredit compteCredit = apprenant.getCompteCredit();
		
		//save pays
		pays = paysRepository.save(pays);
		adresse.setPays(pays);

		//save address
		adresse = adresseRepository.save(adresse);
		result.setAdresse(adresse);
		
		//save comptecredit
		compteCredit = compteCreditRepository.save(compteCredit);
		compteCredit.setApprenant(result);
		compteCredit = compteCreditRepository.save(compteCredit);
		result.setCompteCredit(compteCredit);
		
		
		//save apprenant
		result = apprenantRepository.save(result);
		

		
		System.out.println("apprenant saved");

		return result;
	}

}
