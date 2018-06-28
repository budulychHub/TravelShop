package ua.com.travel.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ua.com.travel.dao.ProviderDao;
import ua.com.travel.dao.SleepingDao;
import ua.com.travel.entity.Provider;
import ua.com.travel.entity.SleepingBag;
import ua.com.travel.service.SleepingBagService;
import ua.com.travel.validationSleepingBag.ValidatorSleepingBag;

@Service
public class SleepingBagServiceImpl implements SleepingBagService {

	@Autowired
	private SleepingDao sleepingDao;
	@Autowired
	private ProviderDao providerDao;

	@Autowired
	@Qualifier("sleepingBagValidator")
	private ValidatorSleepingBag validatorSleepingBag;

	public void save(SleepingBag sleepingBag) throws Exception {
		validatorSleepingBag.validate(sleepingBag);
		sleepingDao.save(sleepingBag);
	}

	public List<SleepingBag> findAll() {
		return sleepingDao.findAll();
	}

	public SleepingBag findOne(int id) {
		return sleepingDao.findOne(id);
	}

	public void delete(int id) {
		SleepingBag sleepingBag = sleepingDao.findSleepingBagWithProvider(id);
		for (Provider provider : sleepingBag.getProviders()) {
			provider.setSleepingBags(null);
			providerDao.save(provider);
		}
		sleepingDao.delete(id);
	}

	public List<SleepingBag> findSleepingBagWithProvider() {
		return sleepingDao.findSleepingBagWithProvider();
	}

	@Transactional
	public void saveImg(int idBag, MultipartFile multipartFile) {
		SleepingBag sleepingBag = sleepingDao.findOne(idBag);

		String path = System.getProperty("catalina.home") + "/resources/" + sleepingBag.getBrand() + "/"
				+ multipartFile.getOriginalFilename();

		sleepingBag.setImgBag("resources/" +

				sleepingBag.getBrand() + "/" + multipartFile.getOriginalFilename());

		File file = new File(path);

		try {
			file.mkdirs();
			try {
				FileUtils.cleanDirectory(
						new File(System.getProperty("catalina.home") + "/resources/" + sleepingBag.getBrand() + "/"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			multipartFile.transferTo(file);
		} catch (IOException e) {
			System.out.println("error with file");
		}

	}
}
