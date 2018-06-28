package ua.com.travel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ua.com.travel.dao.ProviderDao;
import ua.com.travel.dao.TentDao;
import ua.com.travel.entity.Provider;
import ua.com.travel.entity.Tent;
import ua.com.travel.service.TentService;
import ua.com.travel.validationTent.ValidatorTent;

@Service
public class TentServiceImpl implements TentService {

	@Autowired
	private TentDao tentDao;
	@Autowired
	private ProviderDao providerDao;

	@Autowired
	@Qualifier("tentValidator")
	private ValidatorTent validatorTent;

	public void save(Tent tent) throws Exception {
		validatorTent.validate(tent);
		tentDao.save(tent);
	}

	public List<Tent> findAll() {
		return tentDao.findAll();
	}

	public Tent findOne(int id) {
		return tentDao.findOne(id);
	}

	public void delete(int id) {
		Tent tent = tentDao.findTentWithProvider(id);
		for (Provider provider : tent.getProviders()) {
			provider.setTents(null);
			providerDao.save(provider);
		}
		tentDao.delete(id);
	}

	public List<Tent> findTentWithProvider() {
		return tentDao.findTentWithProvider();
	}

}
