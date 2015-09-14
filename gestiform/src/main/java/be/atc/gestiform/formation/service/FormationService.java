package be.atc.gestiform.formation.service;

import org.neo4j.cypher.internal.compiler.v2_1.planner.logical.findShortestPaths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.atc.gestiform.formation.entity.Formation;
import be.atc.gestiform.formation.repository.FormationRepository;

@Service
public class FormationService {

	@Autowired
	FormationRepository formationRepository;

	/**
	 * Retrieves a formation by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the apprenant with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public Formation findOne(Integer formationId) {
		return formationRepository.findOne(formationId);
	}

	/**
	 * find all formation in DB
	 * @return
	 */
	public Iterable<Formation> findAllFormation() {
		return formationRepository.findAll();
	}

	/**
	 * save new or update existing formation
	 * @param formation
	 * @return
	 */
	public Formation save(Formation formation) {
		return formationRepository.save(formation);
	}
}
