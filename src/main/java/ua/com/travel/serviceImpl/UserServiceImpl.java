package ua.com.travel.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ua.com.travel.entity.Backpack;
import ua.com.travel.entity.Role;
import ua.com.travel.validation.ValidatorUser;
import ua.com.travel.validationImgUser.ValidatorImgUser;
import ua.com.travel.dao.BackpackDao;
import ua.com.travel.dao.UserDao;
import ua.com.travel.entity.User;
import ua.com.travel.service.UserService;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	@Qualifier("userValidator")
	private ValidatorUser validator;

	@Autowired
	@Qualifier("imgUserValidator")
	private ValidatorImgUser validatorImgUser;

	public void save(User user) throws Exception {

		validator.validate(user);

		user.setRole(Role.ROLE_USER);
		user.setPassword(encoder.encode(user.getPassword()));
		userDao.save(user);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	public User findOne(int id) {
		return userDao.findOne(id);
	}

	public void delete(int id) {
		userDao.delete(id);

	}

	public User findByName(String name) {
		return userDao.findByName(name);
	}

	public User findByUuid(String uuid) {
		return userDao.findByUUID(uuid);
	}

	public void update(User user) {
		userDao.save(user);
	}

	public void updateProfile(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userDao.save(user);
	}

	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		return userDao.findByName(name);
	}

	@Transactional
	public void saveImage(Principal principal, MultipartFile multipartFile) throws Exception {

		validatorImgUser.validate(userDao.findOne(Integer.parseInt(principal.getName())));

		User user = userDao.findOne(Integer.parseInt(principal.getName()));

		String path = System.getProperty("catalina.home") + "/resources/" + user.getName() + "/"
				+ multipartFile.getOriginalFilename();

		user.setPathImage("resources/" + user.getName() + "/" + multipartFile.getOriginalFilename());

		File file = new File(path);

		try {
			file.mkdirs();
			try {
				FileUtils.cleanDirectory(
						new File(System.getProperty("catalina.home") + "/resources/" + user.getName() + "/"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			multipartFile.transferTo(file);
		} catch (IOException e) {
			System.out.println("error with file");
		}
	}

	public User fetchUserWithBackpack(int id) {
		return userDao.fetchUserWithBackpack(id);
	}

	///////////////////////////////
	// for cookie

	@Autowired
	private BackpackDao backpackDao;

	public Cookie intoBasket(int id, HttpServletRequest request, HttpServletResponse response) {
		request.getSession(false);
		Backpack backpack = backpackDao.findOne(id);
		Cookie cookieBackpack = new Cookie(backpack.getBrand(), String.valueOf(backpack.getId()));

		cookieBackpack.setMaxAge(24 * 60 * 60 * 60);
		cookieBackpack.setHttpOnly(true);
		cookieBackpack.setPath("/");

		response.addCookie(cookieBackpack);
		return cookieBackpack;
	}

	public List<Backpack> userBackpacksCookie(HttpServletRequest request) {

		request.getSession(false);
		List<Backpack> backpacks = new ArrayList<Backpack>();
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals("JSESSIONID")) {

			} else {
				backpacks.add(backpackDao.findOne(Integer.parseInt(cookie.getValue())));
			}
		}
		return backpacks;
	}

	@Transactional
	public void getOrder(Principal principal, String id, HttpServletRequest request, HttpServletResponse response) {
		User user = userDao.fetchUserWithBackpack(Integer.parseInt(principal.getName()));
		Backpack backpack = backpackDao.findOne(Integer.parseInt(id));
		user.getBackpacks().add(backpack);

		Cookie[] cookies = request.getCookies();
		sortCookie(cookies, id, response);

	}

	public void deleteCookieFromOrder(String id, HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		sortCookie(cookies, id, response);
	}

	public void sortCookie(Cookie[] cookies, String id, HttpServletResponse response) {
		for (int i = 0; i < cookies.length; i++) {
			if (id.equals(cookies[i].getValue())) {
				Cookie cookie = new Cookie(cookies[i].getName(), null);
				cookie.setHttpOnly(true);
				cookie.setPath("/");
				cookie.setValue(null);
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
	}

}
