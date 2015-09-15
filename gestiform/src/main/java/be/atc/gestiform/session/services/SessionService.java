package be.atc.gestiform.session.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.atc.gestiform.common.services.BaseService;
import be.atc.gestiform.session.entity.Session;
import be.atc.gestiform.session.repository.SessionRepository;

@Service
public class SessionService implements BaseService<Session>{

	@Autowired
	SessionRepository sessionRepository;

	/**
	 * Retrieves a session by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the session with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public Session findOne(Integer formationId) {
		return sessionRepository.findOne(formationId);
	}

	/**
	 * find all session in DB
	 * @return
	 */
	public Iterable<Session> findAll() {
		return sessionRepository.findAll();
	}

	/**
	 * save new or update existing session
	 * @param formation
	 * @return
	 */
	public Session save(Session session) {
		return sessionRepository.save(session);
	}
}
