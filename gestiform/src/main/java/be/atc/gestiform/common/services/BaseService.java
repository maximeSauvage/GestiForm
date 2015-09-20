package be.atc.gestiform.common.services;

import org.springframework.data.jpa.domain.AbstractPersistable;

public interface BaseService<T extends AbstractPersistable<?>> {

	/**
	 * Retrieves an entity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the entity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	T findOne(Integer entityId);

	/**
	 * find all entities in DB
	 * @return
	 */
	Iterable<T> findAll();

	/**
	 * save new or update existing entity
	 * @param formation
	 * @return
	 */
	T save(T entity);

}
