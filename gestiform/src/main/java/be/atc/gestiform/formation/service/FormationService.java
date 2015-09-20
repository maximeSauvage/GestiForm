package be.atc.gestiform.formation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.atc.gestiform.common.services.BaseService;
import be.atc.gestiform.formation.entity.Formation;
import be.atc.gestiform.formation.repository.FormationRepository;

@Service
public class FormationService implements BaseService<Formation> {

	@Autowired
	FormationRepository formationRepository;

	/* (non-Javadoc)
	 * @see be.atc.gestiform.formation.service.BasicService#findOne(java.lang.Integer)
	 */
	@Override
	public Formation findOne(Integer formationId) {
		return formationRepository.findOne(formationId);
	}

	/* (non-Javadoc)
	 * @see be.atc.gestiform.formation.service.BasicService#findAllFormation()
	 */
	@Override
	public Iterable<Formation> findAll() {
		return formationRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see be.atc.gestiform.formation.service.BasicService#save(be.atc.gestiform.formation.entity.Formation)
	 */
	@Override
	public Formation save(Formation formation) {
		return formationRepository.save(formation);
	}
}
