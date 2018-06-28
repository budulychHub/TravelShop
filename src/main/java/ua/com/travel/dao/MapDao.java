package ua.com.travel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.travel.entity.Map;

public interface MapDao extends JpaRepository<Map, Integer>{

	@Query("select distinct m from Map m left join fetch m.providers")
	List<Map> findMapWithProvider();
	
	@Query("select distinct m from Map m left join fetch m.providers where m.id =:id")
	Map findMapWithProvider(@Param("id") int id);
}
