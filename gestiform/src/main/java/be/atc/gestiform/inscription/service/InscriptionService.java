package be.atc.gestiform.inscription.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.atc.gestiform.common.services.BaseService;
import be.atc.gestiform.inscription.entity.Inscription;
import be.atc.gestiform.inscription.repository.InscriptionRepository;

@Service
public class InscriptionService implements BaseService<Inscription>{
	
	@Autowired
	InscriptionRepository inscriptionRepository;

	@Override
	public Inscription findOne(Integer entityId) {
		return inscriptionRepository.findOne(entityId);
	}

	@Override
	public Iterable<Inscription> findAll() {
		return inscriptionRepository.findAll();
	}

	@Override
	public Inscription save(Inscription entity) {
		return inscriptionRepository.save(entity);
	}

	/**
	 * find all inscription of a session
	 * @param id
	 * @return
	 */
	public List<Inscription> findBySession_Id(Integer id) {
		return inscriptionRepository.findBySession_Id(id);
	}

	public void delete(Integer id) {
		inscriptionRepository.delete(id);
	}

}
