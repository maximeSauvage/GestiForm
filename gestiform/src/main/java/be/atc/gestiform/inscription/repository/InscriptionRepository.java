package be.atc.gestiform.inscription.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import be.atc.gestiform.inscription.entity.Inscription;

public interface InscriptionRepository extends CrudRepository<Inscription, Integer>{

	public List<Inscription> findBySession_Id(Integer id);

}
