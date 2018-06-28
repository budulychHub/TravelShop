package ua.com.travel.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ua.com.travel.entity.SleepingBag;

public interface SleepingBagService {
 
	void save (SleepingBag sleepingBag) throws Exception;
	List<SleepingBag> findAll();
	SleepingBag findOne (int id);
	void delete (int id);
	
	List<SleepingBag> findSleepingBagWithProvider();
	
	void saveImg(int idBag, MultipartFile multipartFile);
	
}
