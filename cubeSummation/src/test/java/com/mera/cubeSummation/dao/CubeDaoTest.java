/**
 * 
 */
package com.mera.cubeSummation.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mera.cubeSummation.entity.Cube;

/**
 * @author DavidCamilo
 *         <p>
 *         Test case for {@link CubeDAO}
 *         </p>
 */
public class CubeDaoTest {

	private static final String QUERY_FORMAT = "qUErY %d %d %d %d %d %d";

	private static final String UPDATE_FORMAT = "UpDaTe %d %d %d %d";
	
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
}
