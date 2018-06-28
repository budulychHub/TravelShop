package ua.com.travel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.travel.entity.Tent;

public interface TentDao extends JpaRepository<Tent, Integer> {

	@Query("select distinct t from Tent t left join fetch t.providers")
	List<Tent> findTentWithProvider();
	
	@Query("select distinct t from Tent t left join fetch t.providers where t.id =:id")
	Tent findTentWithProvider(@Param("id") int id);
}
