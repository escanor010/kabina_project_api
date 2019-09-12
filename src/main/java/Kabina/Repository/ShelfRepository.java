package Kabina.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Kabina.Model.Shelf;

@Repository
public interface ShelfRepository extends JpaRepository<Shelf, Integer> {
	List<Shelf> findAll();

	@Query(value = "SELECT * FROM shelf where business_unit_id = ?1", nativeQuery = true)
	List<Shelf> getAllShelvesByUnitId(long id);
}
