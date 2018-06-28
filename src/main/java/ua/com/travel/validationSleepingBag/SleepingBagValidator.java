package ua.com.travel.validationSleepingBag;

import org.springframework.stereotype.Component;

import ua.com.travel.entity.SleepingBag;

@Component("sleepingBagValidator")
public class SleepingBagValidator implements ValidatorSleepingBag {

	public void validate (Object object) throws Exception{
		SleepingBag sleepingBag = (SleepingBag) object;
		
		if(sleepingBag.getBrand().isEmpty()){
			throw new SleepingBagValidationException(ValidatorMessegeSleepingBag.EMPTY_BRAND_FIELD);
		}
		if(sleepingBag.getWeight()==0){
			throw new SleepingBagValidationException(ValidatorMessegeSleepingBag.EMPTY_WEIGHT_FIELD);
		}
		if(sleepingBag.getHeight()==0){
			throw new SleepingBagValidationException(ValidatorMessegeSleepingBag.EMPTY_HEIGHT_FIELD);
		}
		if(sleepingBag.getPrice()==0){
			throw new SleepingBagValidationException(ValidatorMessegeSleepingBag.EMPTY_PRICE_FIELD);
		}
		if(sleepingBag.getProviders().isEmpty()){
			throw new SleepingBagValidationException(ValidatorMessegeSleepingBag.EMPTY_PROVIDERR_FIELD);
		}
	}
}
