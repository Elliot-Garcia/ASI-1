package card.controller;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import card.model.Cards;

public interface RepositoryCards extends CrudRepository<Cards, Integer> {
	
	@Query("Select c FROM Cards c WHERE c.id_User = ?1")
	List<Cards> findAllByIdUser(int idUser);
	
}