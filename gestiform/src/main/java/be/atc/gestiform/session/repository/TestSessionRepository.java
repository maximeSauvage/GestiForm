package be.atc.gestiform.session.repository;


import org.springframework.data.repository.CrudRepository;

import be.atc.gestiform.session.entity.TestSession;

public interface TestSessionRepository extends CrudRepository<TestSession,Integer> {
}
