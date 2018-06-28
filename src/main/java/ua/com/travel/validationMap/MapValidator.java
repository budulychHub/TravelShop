package ua.com.travel.validationMap;

import org.springframework.stereotype.Component;

import ua.com.travel.entity.Map;

@Component("mapValidator")
public class MapValidator implements ValidatorMap{

	public void validate(Object object) throws Exception{
		Map map = (Map) object;
		
		if(map.getNameLacality().isEmpty()){
			throw new MapValidationException(ValidatorMessegeMap.EMPTY_NAME_LOCALITY_FIELD);
		}
		if(map.getScale()==0){
			throw new MapValidationException(ValidatorMessegeMap.EMPTY_SCALE_FIELD);
		}
		if(map.getPrice()==0){
			throw new MapValidationException(ValidatorMessegeMap.EMPTY_PRICEE_FIELD);
		}
		if(map.getProviders().isEmpty()){
			throw new MapValidationException(ValidatorMessegeMap.EMPTY_PROVIDERR_FIELD);
		}
	}
}
