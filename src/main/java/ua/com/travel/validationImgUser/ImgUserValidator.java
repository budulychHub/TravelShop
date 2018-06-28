package ua.com.travel.validationImgUser;

import org.springframework.stereotype.Component;

import ua.com.travel.entity.User;

@Component("imgUserValidator")
public class ImgUserValidator implements ValidatorImgUser{

	
	public void validate(Object object) throws Exception {
		User user = (User) object;
		
		if(user.getPathImage().isEmpty()){
			throw new ImgUserValidationeException(ValidatorMessegeImgUser.EMPTY_IMG_FIELD);
		}
	}

	
	
}
