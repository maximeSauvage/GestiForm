package be.atc.gestiform.competence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.atc.gestiform.common.services.BaseService;
import be.atc.gestiform.competence.entity.Competence;
import be.atc.gestiform.competence.repository.CompetenceRepository;

@Service
public class CompetenceService implements BaseService<Competence>{
	
	@Autowired
	CompetenceRepository competenceRepository;

	@Override
	public Competence findOne(Integer entityId) {
		return competenceRepository.findOne(entityId);
	}

	@Override
	public Iterable<Competence> findAll() {
		return competenceRepository.findAll();
	}

	@Override
	public Competence save(Competence entity) {
		return competenceRepository.save(entity);
	}

}
