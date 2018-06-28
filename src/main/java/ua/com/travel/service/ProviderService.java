package ua.com.travel.service;

import java.util.List;

import ua.com.travel.entity.Provider;

public interface ProviderService {

	void save (Provider provider) throws Exception;
	List<Provider> findAll();
	Provider findOne (int id);
	void delete (int id);
}
