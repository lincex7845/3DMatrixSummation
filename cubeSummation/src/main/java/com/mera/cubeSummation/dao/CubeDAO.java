/**
 * 
 */
package com.mera.cubeSummation.dao;

import javax.validation.constraints.NotNull;

import com.mera.cubeSummation.entity.Coordinate;
import com.mera.cubeSummation.entity.Cube;

/**
 * @author DavidCamilo
 *         <p>
 *         Instance of {@link ICubeDAO}. This class represents a set of
 *         operations to be performed against any {@link Cube}
 *         </p>
 */
public class CubeDAO implements ICubeDAO {

	private Cube cube;

	/**
	 * Constructor
	 * 
	 * @param cube
	 *            A not null instance of {@link Cube}
	 */
	public CubeDAO(@NotNull Cube cube) {
		this.cube = cube;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mera.cubeSummation.dao.ICubeDAO#updateBlockValue(java.lang.String)
	 */
	@Override
	public void updateBlockValue(String updateCommand) {

		String[] updateCommandParameters = updateCommand.split(BLANK_SPACE);
		Coordinate blockCoordinates = new Coordinate(
				Integer.parseInt(updateCommandParameters[1]),
				Integer.parseInt(updateCommandParameters[2]),
				Integer.parseInt(updateCommandParameters[3]));
		int newValue = Integer.parseInt(updateCommandParameters[4]);
		cube.updateBlockValue(blockCoordinates, newValue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mera.cubeSummation.dao.ICubeDAO#querySummatoryBetweenBlocks(java.
	 * lang.String)
	 */
	@Override
	public long querySummatoryBetweenBlocks(String queryCommand) {

		String[] queryCommandParameters = queryCommand.split(BLANK_SPACE);
		Coordinate startBlockCoordinates = new Coordinate(
				Integer.parseInt(queryCommandParameters[1]),
				Integer.parseInt(queryCommandParameters[2]),
				Integer.parseInt(queryCommandParameters[3]));
		Coordinate endBlockCoordinates = new Coordinate(
				Integer.parseInt(queryCommandParameters[4]),
				Integer.parseInt(queryCommandParameters[5]),
				Integer.parseInt(queryCommandParameters[6]));
		return cube.getSummationBetweenBlocks(startBlockCoordinates,
				endBlockCoordinates);
	}

}