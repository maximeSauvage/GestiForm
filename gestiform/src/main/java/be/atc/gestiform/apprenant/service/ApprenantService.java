package be.atc.gestiform.apprenant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.atc.gestiform.apprenant.entity.Adresse;
import be.atc.gestiform.apprenant.entity.Apprenant;
import be.atc.gestiform.apprenant.entity.Pays;
import be.atc.gestiform.apprenant.repository.AdresseRepository;
import be.atc.gestiform.apprenant.repository.ApprenantRepository;
import be.atc.gestiform.apprenant.repository.PaysRepository;

@Service
public class ApprenantService {
	
	@Autowired
	ApprenantRepository apprenantRepository;
	@Autowired
	AdresseRepository adresseRepository;
	@Autowired
	PaysRepository paysRepository;
	
	public Iterable<Apprenant> findAllApprenant() {
		
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
		
		if (pays.isNew()) {
			pays = paysRepository.save(pays);

			adresse.setPays(pays);
			result.setAdresse(adresse);
		}
		
		if (adresse.isNew()) {
			adresse = adresseRepository.save(adresse);

			result.setAdresse(adresse);
		}
		
		result = apprenantRepository.save(result);
		
		System.out.println("apprenant saved");

		return result;
	}

}
