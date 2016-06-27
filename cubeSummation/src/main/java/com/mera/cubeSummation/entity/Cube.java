/**
 * 
 */
package com.mera.cubeSummation.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.mera.cubeSummation.commons.Constraints;

/**
 * @author DavidCamilo
 *         <p>
 *         This class represents a three dimensional matrix, also known as Cube
 *         </p>
 */
public class Cube {

	private int dimensionSize;

	private int[][][] matrix;

	/**
	 * Constructor.
	 * 
	 * @param dimensionSize
	 *            The number of blocks per dimension.<br/>
	 *            The minimum value is
	 *            {@link Constraints#MIN_SIZE_PER_DIMENSION}<br/>
	 *            The maximum value is
	 *            {@link Constraints#MAX_SIZE_PER_DIMENSION}
	 */
	public Cube(
			@Max(Constraints.MAX_SIZE_PER_DIMENSION) @Min(Constraints.MIN_SIZE_PER_DIMENSION) int dimensionSize) {
		this.dimensionSize = dimensionSize;
		this.matrix = new int[dimensionSize][dimensionSize][dimensionSize];
	}

	/**
	 * This method allows to update the value in a specific block
	 * 
	 * @param blockCoordinate
	 *            The coordinates of the block
	 * @param value
	 *            The value to be stored. The minimum value to be saved is -10<sup>9</sup>
	 *            The maximum value to be saved is 10<sup>9</sup>
	 */
	public void updateBlockValue(
			@NotNull Coordinate blockCoordinates,
			@Min(Constraints.MIN_VALUE_IN_BLOCK) @Max(Constraints.MAX_VALUE_IN_BLOCK) int value) {
		this.matrix[blockCoordinates.getX() - 1][blockCoordinates.getY() - 1][blockCoordinates
				.getZ() - 1] = value;
	}

	/**
	 * This method returns the summation between two block.
	 * 
	 * @param startBlockCoordinates The block which starts the summation
	 * @param endBlockCoordinates The block which end the summation
	 * @return The value of the summation between the start-block and the end-block.
	 * 
	 */
	public long getSummationBetweenBlocks(Coordinate startBlockCoordinates,
			Coordinate endBlockCoordinates) {
		long summatory = 0;
		for (int i = startBlockCoordinates.getX() - 1; i < endBlockCoordinates
				.getX(); i++) {
			for (int j = startBlockCoordinates.getY() - 1; j < endBlockCoordinates
					.getY(); j++) {
				for (int k = startBlockCoordinates.getZ() - 1; k < endBlockCoordinates
						.getZ(); k++) {
					summatory += this.matrix[i][j][k];
				}
			}
		}
		return summatory;
	}

	/**
	 * @return the dimensionSize
	 */
	public int getDimensionSize() {
		return dimensionSize;
	}

	/**
	 * @return the matrix
	 */
	public int[][][] getMatrix() {
		return matrix;
	}

}