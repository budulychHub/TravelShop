package ua.com.travel.service;

import java.util.List;

import ua.com.travel.entity.Tent;

public interface TentService {

	void save (Tent tent) throws Exception;
	List<Tent> findAll();
	Tent findOne (int id);
	void delete (int id);
	
	List<Tent> findTentWithProvider();
	
}
