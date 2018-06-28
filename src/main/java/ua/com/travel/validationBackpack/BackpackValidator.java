package ua.com.travel.validationBackpack;

import org.springframework.stereotype.Component;

import ua.com.travel.entity.Backpack;

@Component("backpackValidator")
public class BackpackValidator implements ValidatorBackpack{

	
	public void validate(Object object) throws Exception{
		Backpack backpack = (Backpack) object;
		
		if(backpack.getBrand().isEmpty()){
			throw new BackpackValidationException(ValidatorMessegeBackpack.EMPTY_BRAND_FIELD);
		}
		if(backpack.getWeight()==0){
			throw new BackpackValidationException(ValidatorMessegeBackpack.EMPTY_WEIGHT_FIELD);
		}
		if(backpack.getVolume()==0){
			throw new BackpackValidationException(ValidatorMessegeBackpack.EMPTY_VOLUME_FIELD);
		}
		if(backpack.getPrice()==0){
			throw new BackpackValidationException(ValidatorMessegeBackpack.EMPTY_PRICE_FIELD);
		}
		if(backpack.getProviders().isEmpty()){
			throw new BackpackValidationException(ValidatorMessegeBackpack.EMPTY_PROVIDER_FIELD);
		}
	}
}
