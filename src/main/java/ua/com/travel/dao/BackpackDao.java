package ua.com.travel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.travel.entity.Backpack;

public interface BackpackDao extends JpaRepository<Backpack, Integer> {

	@Query("select distinct b from Backpack b left join fetch b.providers")
	List<Backpack> findBackpackWithProvider();

	@Query("select distinct b from Backpack b left join fetch b.providers where b.id =:id")
	Backpack findBackpackWithProvider(@Param("id") int id);
}
