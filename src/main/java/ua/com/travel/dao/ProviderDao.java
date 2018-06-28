package ua.com.travel.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.travel.entity.Provider;

public interface ProviderDao extends JpaRepository<Provider, Integer> {

	
	@Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM Provider p WHERE p.name =:name")
	boolean providerExistsByName(@Param("name") String name);
	
	@Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM Provider p WHERE p.email =:email")
	boolean providerExistsByEmail(@Param("email") String email);
	
	@Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM Provider p WHERE p.phone =:phone")
	boolean providerExistsByPhone(@Param("phone") String phone);
}
