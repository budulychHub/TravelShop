package ua.com.travel.service;

import java.util.List;

import ua.com.travel.entity.Backpack;

public interface BackpackService {

	void save(Backpack backpack) throws Exception;

	List<Backpack> findAll();

	Backpack findOne(int id);

	void delete(int id);

	List<Backpack> findBackpackWithProvider();

}
