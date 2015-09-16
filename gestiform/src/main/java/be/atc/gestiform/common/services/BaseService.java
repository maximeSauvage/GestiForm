package be.atc.gestiform.common.services;

import org.springframework.data.jpa.domain.AbstractPersistable;

import be.atc.gestiform.formation.entity.Formation;

public interface BaseService<T extends AbstractPersistable<?>> {
	

	/**
	 * Retrieves an entity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the entity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public T findOne(Integer entityOd);

	/**
	 * find all entities in DB
	 * @return
	 */
	public Iterable<T> findAll();

	/**
	 * save new or update existing entity
	 * @param formation
	 * @return
	 */
	public T save(T formation);

}
