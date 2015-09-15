package be.atc.gestiform.session.repository;


import org.springframework.data.repository.CrudRepository;

import be.atc.gestiform.session.entity.Session;

public interface SessionRepository extends CrudRepository<Session,Integer> {
}
