package ua.com.travel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ua.com.travel.dao.ProviderDao;
import ua.com.travel.entity.Provider;
import ua.com.travel.service.ProviderService;
import ua.com.travel.validationProvider.ValidatorProvider;

@Service
public class ProviderServiceImpl implements ProviderService{

	@Autowired
	private ProviderDao providerDao;

	@Autowired
	@Qualifier(value="providerValidator")
	private ValidatorProvider validatorProvider;
	
	
	public void save(Provider provider) throws Exception {
		validatorProvider.validate(provider);
		providerDao.save(provider);
	}

	public List<Provider> findAll() {
		return providerDao.findAll();
	}

	public Provider findOne(int id) {
		
		return providerDao.findOne(id);
	}

	public void delete(int id) {
		providerDao.delete(id);
	}
	
	
}
