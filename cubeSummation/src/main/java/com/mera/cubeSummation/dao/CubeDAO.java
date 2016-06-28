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
		validateCoordinate(blockCoordinates);
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
		validateCoordinates(startBlockCoordinates, endBlockCoordinates);
		return cube.getSummationBetweenBlocks(startBlockCoordinates,
				endBlockCoordinates);
	}

	/**
	 * This method checks if the given coordinates are compliant with the following
	 * restrictions
	 * 
	 * <pre>
	 *  1 <= x1 <= x2 <= N 
	 *  1 <= y1 <= y2 <= N 
	 *  1 <= z1 <= z2 <= N 
	 *  1 <= x,y,z <= N
	 * </pre>
	 * 
	 * @param startBlockCoordinates
	 * @param endBlockCoordinates
	 * @return
	 */
	private void validateCoordinates(Coordinate startBlockCoordinates,
			Coordinate endBlockCoordinates) {

		validateCoordinate(startBlockCoordinates);
		validateCoordinate(endBlockCoordinates);
		if (startBlockCoordinates.getX() <= endBlockCoordinates.getX()
				&& startBlockCoordinates.getY() <= endBlockCoordinates.getY()
				&& startBlockCoordinates.getZ() <= endBlockCoordinates.getZ()) {
			return;
		} else {
			throw new UnsupportedOperationException(String.format(
					"The coordinates %s must be less than %s coordinates",
					startBlockCoordinates.toString(),
					endBlockCoordinates.toString()));
		}
	}

	/**
	 * This method validates if the given coordinates are not out of matrix
	 * boundaries
	 * 
	 * @param blockCoordinates
	 * @return
	 */
	private void validateCoordinate(Coordinate blockCoordinates) {

		if (isValidAxisValue(blockCoordinates.getX())
				&& isValidAxisValue(blockCoordinates.getY())
				&& isValidAxisValue(blockCoordinates.getZ())) {
			return;
		} else {
			throw new UnsupportedOperationException(String.format(
					"The coordinates %s are out of boundaries",
					blockCoordinates.toString()));
		}
	}

	/**
	 * This method validates if the given value is less than or equals to the
	 * {@link Cube#dimensionSize} value
	 * 
	 * @param axisValue
	 * @return
	 */
	private boolean isValidAxisValue(int axisValue) {

		return axisValue <= cube.getDimensionSize();
	}
}