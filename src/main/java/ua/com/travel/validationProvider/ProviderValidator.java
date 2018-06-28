package ua.com.travel.validationProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.travel.dao.ProviderDao;
import ua.com.travel.entity.Provider;

@Component("providerValidator")
public class ProviderValidator implements ValidatorProvider{

	@Autowired
	private ProviderDao providerDao;
	
	public void validate(Object object) throws Exception{
		Provider provider = (Provider) object;
		
		if(providerDao.providerExistsByName(provider.getName()) == true){
			throw new ProviderValidationException(ValidatorMessegesProvider.NAME_ALREADY_EXIST);
		}
		if(providerDao.providerExistsByEmail(provider.getEmail()) == true){
			throw new ProviderValidationException(ValidatorMessegesProvider.EMAIL_ALREADY_EXIST);
		}
		if(providerDao.providerExistsByPhone(provider.getPhone()) == true){
			throw new ProviderValidationException(ValidatorMessegesProvider.PHONE_ALREADY_EXIST);
		}
		
		if(provider.getName().isEmpty()){
			throw new ProviderValidationException(ValidatorMessegesProvider.EMPTY_NAME_FIELD);
		}
		if(provider.getEmail().isEmpty()){
			throw new ProviderValidationException(ValidatorMessegesProvider.EMPTY_EMAIL_FIELD);
		}
		if(provider.getPhone().isEmpty()){
			throw new ProviderValidationException(ValidatorMessegesProvider.EMPTY_PHONE_FIELD);
		}
	}
}
