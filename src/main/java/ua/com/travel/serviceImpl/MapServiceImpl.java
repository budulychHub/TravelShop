package ua.com.travel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ua.com.travel.dao.MapDao;
import ua.com.travel.dao.ProviderDao;
import ua.com.travel.entity.Map;
import ua.com.travel.entity.Provider;
import ua.com.travel.service.MapService;
import ua.com.travel.validationMap.ValidatorMap;

@Service
public class MapServiceImpl implements MapService{

	@Autowired
	private MapDao mapDao;
	@Autowired
	private ProviderDao providerDao;
	
	@Autowired
	@Qualifier("mapValidator")
	private ValidatorMap validatorMap;
	
	public void save(Map map) throws Exception{
		validatorMap.validate(map);
		mapDao.save(map);
	}

	public List<Map> findAll() {
		return mapDao.findAll();
	}

	public Map findOne(int id) {
		return mapDao.findOne(id);
	}

	public void delete(int id) {
		Map map = mapDao.findMapWithProvider(id);
		for(Provider provider : map.getProviders()){
			provider.setMaps(null);
			providerDao.save(provider);
		}
		mapDao.delete(id);
	}

	public List<Map> findMapWithProvider() {
		return mapDao.findMapWithProvider();
	}

}
