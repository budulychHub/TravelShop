package ua.com.travel.service;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import ua.com.travel.entity.Backpack;
import ua.com.travel.entity.User;

public interface UserService {

	void save (User user) throws Exception;
	List<User> findAll();
	User findOne(int id);
	void delete (int id);
	
	User findByName(String name);
	User findByUuid(String uuid);
	
	void update(User user);
	 void updateProfile(User user);
	
	User fetchUserWithBackpack( int id);
	
	void saveImage(Principal principal, MultipartFile multipartFile) throws Exception;
	
	
	
// for cookie
    
    public Cookie intoBasket(int id, HttpServletRequest request, HttpServletResponse response);
    
    List<Backpack> userBackpacksCookie(HttpServletRequest request);
    
    public void getOrder(Principal principal, String id, HttpServletRequest request, HttpServletResponse response);
    
    public void deleteCookieFromOrder(String id, HttpServletRequest request, HttpServletResponse response);
	
}
