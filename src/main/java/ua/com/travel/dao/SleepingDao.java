package ua.com.travel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.travel.entity.SleepingBag;

public interface SleepingDao extends JpaRepository<SleepingBag, Integer> {

	@Query("select distinct s from SleepingBag s left join fetch s.providers")
	List<SleepingBag> findSleepingBagWithProvider();
	
	@Query("select distinct s from SleepingBag s left join fetch s.providers where s.id =:id")
	SleepingBag findSleepingBagWithProvider(@Param("id") int id);
}
