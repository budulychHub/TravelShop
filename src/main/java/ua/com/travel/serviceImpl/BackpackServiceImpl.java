package ua.com.travel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ua.com.travel.dao.BackpackDao;
import ua.com.travel.dao.ProviderDao;
import ua.com.travel.entity.Backpack;
import ua.com.travel.entity.Provider;
import ua.com.travel.service.BackpackService;
import ua.com.travel.validationBackpack.ValidatorBackpack;

@Service
public class BackpackServiceImpl implements BackpackService {

	@Autowired
	private BackpackDao backpackDao;

	@Autowired
	private ProviderDao providerDao;

	@Autowired
	@Qualifier("backpackValidator")
	private ValidatorBackpack validatorBackpack;

	public void save(Backpack backpack) throws Exception {
		validatorBackpack.validate(backpack);
		backpackDao.save(backpack);
	}

	public List<Backpack> findAll() {
		return backpackDao.findAll();
	}

	public Backpack findOne(int id) {
		return backpackDao.findOne(id);
	}

	public void delete(int id) {
		Backpack backpack = backpackDao.findBackpackWithProvider(id);
		for (Provider provider : backpack.getProviders()) {
			provider.setBackpacks(null);
			providerDao.save(provider);
		}
		backpackDao.delete(id);
	}

	public List<Backpack> findBackpackWithProvider() {
		return backpackDao.findBackpackWithProvider();
	}

}
