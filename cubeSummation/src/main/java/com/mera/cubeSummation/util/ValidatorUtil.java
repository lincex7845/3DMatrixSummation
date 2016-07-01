/**
 * 
 */
package com.mera.cubeSummation.util;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @author DavidCamilo
 *
 */
public class ValidatorUtil {


	private static final ValidatorFactory VALIDATOR_FACTORY = Validation
			.buildDefaultValidatorFactory();

	private static final Validator VALIDATOR = VALIDATOR_FACTORY.getValidator();

	/**
	 * This method checks constraints in objects
	 * 
	 * @param object
	 * @return
	 */
	public static <T> void validate(T object) {
		Set<ConstraintViolation<T>> constraintViolations = VALIDATOR
				.validate(object);
		if (!constraintViolations.isEmpty()) {
			throw new IllegalArgumentException(constraintViolations.iterator()
					.next().getConstraintDescriptor().getMessageTemplate());
		}
	}
}
