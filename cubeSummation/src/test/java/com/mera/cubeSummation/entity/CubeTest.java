/**
 * 
 */
package com.mera.cubeSummation.entity;

import static org.junit.Assert.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.executable.ExecutableValidator;

import org.junit.BeforeClass;
import org.junit.Test;

import com.mera.cubeSummation.commons.Constraints;

/**
 * @author DavidCamilo
 *
 * <p>Test case for {@link Cube}</p>
 */
public class CubeTest {

	private static ValidatorFactory factory;

	private static Validator validator;

	private static ExecutableValidator executableValidator;

	@BeforeClass
	public static void setUp() {

		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		executableValidator = validator.forExecutables();
	}

	/**
	 * Test method for {@link com.mera.cubeSummation.entity.Cube#Cube(int)}.
	 */
	@Test
	public void testCube() {
		Cube cube = new Cube(3);
		assertNotNull(cube);
	}

	/**
	 * Test method for {@link com.mera.cubeSummation.entity.Cube#Cube(int)}.
	 */
	@Test
	public void testFailedCubeConstruction() {
		Cube cube = new Cube(Constraints.MAX_SIZE_PER_DIMENSION + 2);
		Set<ConstraintViolation<Cube>> constraintViolations = validator
				.validate(cube);
		assertTrue(!constraintViolations.isEmpty());
		Class<? extends Annotation> constraintType = constraintViolations
				.iterator().next().getConstraintDescriptor().getAnnotation()
				.annotationType();
		assertEquals(Max.class, constraintType);
		
		constraintViolations.clear();
		cube = new Cube(0);
		constraintViolations = validator.validate(cube);
		assertTrue(!constraintViolations.isEmpty());
		constraintType = constraintViolations.iterator().next()
				.getConstraintDescriptor().getAnnotation().annotationType();
		assertEquals(Min.class, constraintType);
	}

	/**
	 * Test method for
	 * {@link com.mera.cubeSummation.entity.Cube#updateBlockValue(com.mera.cubeSummation.entity.Coordinate, int)}
	 * .
	 */
	@Test
	public void testUpdateBlockValue() {
		Cube cube = new Cube(4);
		Coordinate firstBlockCoordinates = new Coordinate(1, 1, 1);
		cube.updateBlockValue(firstBlockCoordinates, 23);
		assertEquals(23l, cube.getBlockValue(firstBlockCoordinates));
	}

	/**
	 * Test method for
	 * {@link com.mera.cubeSummation.entity.Cube#updateBlockValue(com.mera.cubeSummation.entity.Coordinate, int)}
	 * .
	 * 
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	@Test
	public void testFailedUpdateBlockValue() throws NoSuchMethodException,
			SecurityException {
		
		Cube cube = new Cube(4);
		Coordinate firstBlockCoordinates = new Coordinate(1, 1, 1);
		Coordinate lastBlockCoordinates = new Coordinate(4, 4, 4);
		
		Method updateBlockValueMethod = Cube.class.getMethod("updateBlockValue",
				Coordinate.class, int.class);
		Object[] parameters = new Object[]{ firstBlockCoordinates,
				Constraints.MAX_VALUE_IN_BLOCK + 1 };
		Set<ConstraintViolation<Cube>> constraintViolations = executableValidator
				.validateParameters(cube, updateBlockValueMethod, parameters);
		assertTrue(!constraintViolations.isEmpty());
		Class<? extends Annotation> constraintType = constraintViolations
				.iterator().next().getConstraintDescriptor().getAnnotation()
				.annotationType();
		assertEquals(Max.class, constraintType);
		
		constraintViolations.clear();
		parameters = new Object[]{lastBlockCoordinates,	Constraints.MIN_VALUE_IN_BLOCK - 1};
		constraintViolations = executableValidator
				.validateParameters(cube, updateBlockValueMethod, parameters);
		assertTrue(!constraintViolations.isEmpty());constraintType = constraintViolations
				.iterator().next().getConstraintDescriptor().getAnnotation()
				.annotationType();
		assertEquals(Min.class, constraintType);
	}

	/**
	 * Test method for
	 * {@link com.mera.cubeSummation.entity.Cube#getSummationBetweenBlocks(com.mera.cubeSummation.entity.Coordinate, com.mera.cubeSummation.entity.Coordinate)}
	 * .
	 */
	@Test
	public void testGetSummationBetweenBlocks() {
		Cube cube = new Cube(4);
		Coordinate firstBlockCoordinates = new Coordinate(1, 1, 1);
		Coordinate anotherBlockCoordinates = new Coordinate(3, 3, 3);
		Coordinate lastBlockCoordinates = new Coordinate(4, 4, 4);
		assertEquals(0l, cube.getSummationBetweenBlocks(firstBlockCoordinates,
				anotherBlockCoordinates));
		cube.updateBlockValue(firstBlockCoordinates, 23);
		anotherBlockCoordinates = new Coordinate(2, 2, 2);
		cube.updateBlockValue(anotherBlockCoordinates, 4);
		anotherBlockCoordinates = new Coordinate(2, 2, 2);
		assertEquals(4l, cube.getSummationBetweenBlocks(
				anotherBlockCoordinates, lastBlockCoordinates));
		assertEquals(27l, cube.getSummationBetweenBlocks(firstBlockCoordinates,
				lastBlockCoordinates));
	}

	/**
	 * Test method for
	 * {@link com.mera.cubeSummation.entity.Cube#getDimensionSize()}.
	 */
	@Test
	public void testGetDimensionSize() {
		Cube cube = new Cube(4);
		assertEquals(4, cube.getDimensionSize());
	}

	/**
	 * Test method for {@link com.mera.cubeSummation.entity.Cube#getMatrix()}.
	 */
	@Test
	public void testGetMatrix() {
		Cube cube = new Cube(4);
		assertNotNull(cube.getMatrix());
	}

}
