/**
 * 
 */
package com.mera.cubeSummation.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Pattern;
import javax.validation.executable.ExecutableValidator;

import org.hibernate.validator.constraints.NotBlank;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mera.cubeSummation.entity.Cube;

/**
 * @author DavidCamilo
 *         <p>
 *         Test case for {@link CubeDAO}
 *         </p>
 */
public class CubeDaoTest {

	private static ValidatorFactory factory;

	private static ExecutableValidator executableValidator;

	private static final String QUERY_FORMAT = "qUErY %d %d %d %d %d %d";

	private static final String UPDATE_FORMAT = "UpDaTe %d %d %d %d";

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		factory = Validation.buildDefaultValidatorFactory();
		executableValidator = factory.getValidator().forExecutables();
	}

	/**
	 * Test method for
	 * {@link com.mera.cubeSummation.dao.CubeDAO#updateBlockValue(com.mera.cubeSummation.entity.Cube, java.lang.String)}
	 * .
	 */
	@Test
	public void testUpdateBlockValue() {

		ICubeDAO cubeDAO = new CubeDAO(new Cube(3));
		String updateCommand = String.format(UPDATE_FORMAT, 1, 1, 1, 20);
		cubeDAO.updateBlockValue(updateCommand);
		String queryCommand = String.format(QUERY_FORMAT, 1, 1, 1, 1, 1, 1);
		assertEquals(20l, cubeDAO.querySummatoryBetweenBlocks(queryCommand));
	}

	/**
	 * Test method for
	 * {@link com.mera.cubeSummation.dao.CubeDAO#updateBlockValue(com.mera.cubeSummation.entity.Cube, java.lang.String)}
	 * .
	 * 
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	@Test
	public void testFailedUpdateBlockValue() throws NoSuchMethodException,
			SecurityException {

		ICubeDAO cubeDAO = new CubeDAO(new Cube(3));

		Object[] parameters = new Object[] { null };
		Method updateBlockValueMethod = cubeDAO.getClass().getMethod(
				"updateBlockValue", String.class);
		Set<ConstraintViolation<ICubeDAO>> constraintViolations = executableValidator
				.validateParameters(cubeDAO, updateBlockValueMethod, parameters);
		assertTrue(!constraintViolations.isEmpty());
		Class<? extends Annotation> constraintType = constraintViolations
				.iterator().next().getConstraintDescriptor().getAnnotation()
				.annotationType();
		assertEquals(NotBlank.class, constraintType);

		constraintViolations.clear();
		parameters = new Object[] { "update fake command" };
		constraintViolations = executableValidator.validateParameters(cubeDAO,
				updateBlockValueMethod, parameters);
		assertTrue(!constraintViolations.isEmpty());
		constraintType = constraintViolations.iterator().next()
				.getConstraintDescriptor().getAnnotation().annotationType();
		assertEquals(Pattern.class, constraintType);
	}

	/**
	 * Test method for
	 * {@link com.mera.cubeSummation.dao.CubeDAO#querySummatoryBetweenBlocks(com.mera.cubeSummation.entity.Cube, java.lang.String)}
	 * .
	 */
	@Test
	public void testQuerySummatoryBetweenBlocks() {

		ICubeDAO cubeDAO = new CubeDAO(new Cube(3));
		String updateCommand = String.format(UPDATE_FORMAT, 1, 1, 1, 20);
		cubeDAO.updateBlockValue(updateCommand);
		updateCommand = String.format(UPDATE_FORMAT, 2, 1, 1, 20);
		cubeDAO.updateBlockValue(updateCommand);
		String queryCommand = String.format(QUERY_FORMAT, 2, 1, 1, 3, 3, 3);
		assertEquals(20l, cubeDAO.querySummatoryBetweenBlocks(queryCommand));
		queryCommand = String.format(QUERY_FORMAT, 1, 1, 1, 3, 3, 3);
		assertEquals(40l, cubeDAO.querySummatoryBetweenBlocks(queryCommand));
	}

	/**
	 * Test method for
	 * {@link com.mera.cubeSummation.dao.CubeDAO#querySummatoryBetweenBlocks(com.mera.cubeSummation.entity.Cube, java.lang.String)}
	 * .
	 * 
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	@Test
	public void testFailedQuerySummatoryBetweenBlocks()
			throws NoSuchMethodException, SecurityException {

		ICubeDAO cubeDAO = new CubeDAO(new Cube(3));

		Object[] parameters = new Object[] { " " };
		Method updateBlockValueMethod = cubeDAO.getClass().getMethod(
				"querySummatoryBetweenBlocks", String.class);
		Set<ConstraintViolation<ICubeDAO>> constraintViolations = executableValidator
				.validateParameters(cubeDAO, updateBlockValueMethod, parameters);
		assertTrue(!constraintViolations.isEmpty());
		Class<? extends Annotation> constraintType = constraintViolations
				.iterator().next().getConstraintDescriptor().getAnnotation()
				.annotationType();
		assertTrue(constraintType.getTypeName().equals(
				NotBlank.class.getTypeName())
				|| constraintType.getTypeName().equals(
						Pattern.class.getTypeName()));

		constraintViolations.clear();
		parameters = new Object[] { "QUERY " };
		constraintViolations = executableValidator.validateParameters(cubeDAO,
				updateBlockValueMethod, parameters);
		assertTrue(!constraintViolations.isEmpty());
		constraintType = constraintViolations.iterator().next()
				.getConstraintDescriptor().getAnnotation().annotationType();
		assertEquals(Pattern.class, constraintType);
	}
}
