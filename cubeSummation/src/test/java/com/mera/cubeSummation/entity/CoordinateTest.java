/**
 * 
 */
package com.mera.cubeSummation.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.annotation.Annotation;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.junit.BeforeClass;
import org.junit.Test;

import com.mera.cubeSummation.commons.Constraints;

/**
 * @author DavidCamilo
 * <p>Test case for {@link Coordinate}</p>
 */
public class CoordinateTest {

	private static ValidatorFactory factory;

	private static Validator validator;

	@BeforeClass
	public static void setUp() {

		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	
	/**
	 * Test method for {@link com.mera.cubeSummation.entity.Coordinate#Coordinate(int, int, int)}.
	 */
	@Test
	public void testCoordinate() {
		Coordinate coordinate = new Coordinate(1, 1, 1);
		assertNotNull(coordinate);
	}

	/**
	 * Test method for {@link com.mera.cubeSummation.entity.Coordinate#Coordinate(int, int, int)}.
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	@Test
	public void testFailedCoordinateConstruction() throws NoSuchMethodException, SecurityException{
		
		Coordinate coordinate = new Coordinate(1, 1, 1);
		
		Set<ConstraintViolation<Coordinate>> constraintViolations = validator.validate(coordinate);
		assertTrue(constraintViolations.isEmpty());
		
		coordinate = new Coordinate(Constraints.MAX_SIZE_PER_DIMENSION + 1,
				Constraints.MIN_SIZE_PER_DIMENSION, 1 );
		constraintViolations = validator.validate(coordinate);
		assertTrue(!constraintViolations.isEmpty());		
		Class<? extends Annotation> constraintType = constraintViolations
				.iterator().next().getConstraintDescriptor().getAnnotation()
				.annotationType();
		assertEquals(Max.class, constraintType);
		
		constraintViolations.clear();
		coordinate = new Coordinate(Constraints.MAX_SIZE_PER_DIMENSION ,
				Constraints.MIN_SIZE_PER_DIMENSION - 1, 1 );
		constraintViolations = validator.validate(coordinate);
		assertTrue(!constraintViolations.isEmpty());		
		constraintType = constraintViolations
				.iterator().next().getConstraintDescriptor().getAnnotation()
				.annotationType();
		assertEquals(Min.class, constraintType);
	}
}
