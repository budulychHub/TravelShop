package ua.com.travel.service;

import java.util.List;


import ua.com.travel.entity.Map;

public interface MapService {

	void save (Map map) throws Exception;
	List<Map> findAll();
	Map findOne(int id);
	void delete (int id);
	
	List<Map> findMapWithProvider();
}
