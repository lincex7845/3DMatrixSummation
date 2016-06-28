/**
 * 
 */
package com.mera.cubeSummation.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.mera.cubeSummation.commons.Constraints;

/**
 * @author DavidCamilo
 *         <p>
 *         This class represents each block or square in the three dimensional
 *         matrix
 *         </p>
 */
public class Coordinate {

	@Max(Constraints.MAX_SIZE_PER_DIMENSION)
	@Min(Constraints.MIN_SIZE_PER_DIMENSION)
	private int x;

	@Max(Constraints.MAX_SIZE_PER_DIMENSION)
	@Min(Constraints.MIN_SIZE_PER_DIMENSION)
	private int y;

	@Max(Constraints.MAX_SIZE_PER_DIMENSION)
	@Min(Constraints.MIN_SIZE_PER_DIMENSION)
	private int z;

	/**
	 * <p>
	 * Constructor. The minimum value for each value is
	 * {@link Constraints#MIN_SIZE_PER_DIMENSION}<br/>
	 * The maximum value for each value is
	 * {@link Constraints#MAX_SIZE_PER_DIMENSION}
	 * </p>
	 * 
	 * @param x
	 *            Value in X axis
	 * @param y
	 *            Value in Y axis
	 * @param z
	 *            Value in Z axis
	 */
	public Coordinate(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public String toString(){
		return String.format("[%d, %d, %d]", x, y, z);
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @return the z
	 */
	public int getZ() {
		return z;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @param z
	 *            the z to set
	 */
	public void setZ(int z) {
		this.z = z;
	}
}
