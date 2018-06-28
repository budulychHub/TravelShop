
package ua.com.travel.validation;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import ua.com.travel.dao.UserDao;
import ua.com.travel.entity.User;

@Component("userValidator")
public class UserValidator implements ValidatorUser {

	
	@Autowired
	private UserDao userDao;
	
	
	public void validate(Object object) throws Exception {
		User user = (User) object;
		
		if (userDao.userExistsByName(user.getName()) == true) {
			throw new UserValidationException(ValidatorMesseges.NAME_ALREADY_EXIST);
		}
		if (userDao.userExistsByEmail(user.getEmail())) {
			throw new UserValidationException(ValidatorMesseges.EMAIL_ALREADY_EXIST);
		}
		
		if (user.getName().isEmpty()) {
			throw new UserValidationException(ValidatorMesseges.EMPTY_USERNAME_FIELD);
		}
		if (user.getEmail().isEmpty()) {
			throw new UserValidationException(ValidatorMesseges.EMPTY_EMAIL_FIELD);
		}
		if (user.getPassword().isEmpty()) {
			throw new UserValidationException(ValidatorMesseges.EMPTY_PASSWORD_FIELD);
		}
	}
	
	
}
