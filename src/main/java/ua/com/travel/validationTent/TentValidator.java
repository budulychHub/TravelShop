package ua.com.travel.validationTent;

import org.springframework.stereotype.Component;

import ua.com.travel.entity.Tent;

@Component("tentValidator")
public class TentValidator implements ValidatorTent {

	public void validate(Object object) throws Exception {
		Tent tent = (Tent) object;

		if (tent.getBrand().isEmpty()) {
			throw new TentValidationException(ValidatorMessegeTent.EMPTY_BRAND_FIELD);
		}
		if (tent.getCopacity() == 0) {
			throw new TentValidationException(ValidatorMessegeTent.EMPTY_COPACITY_FIELD);
		}
		if (tent.getWeight() == 0) {
			throw new TentValidationException(ValidatorMessegeTent.EMPTY_WEIGHT_FIELD);
		}
		if (tent.getPrice() == 0) {
			throw new TentValidationException(ValidatorMessegeTent.EMPTY_PRICE_FIELD);
		}
		if (tent.getProviders().isEmpty()) {
			throw new TentValidationException(ValidatorMessegeTent.EMPTY_PROVIDERR_FIELD);
		}
	}

}
