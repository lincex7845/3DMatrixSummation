/**
 * 
 */
package com.mera.cubeSummation.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.mera.cubeSummation.commons.Constraints;

/**
 * @author DavidCamilo
 * <p>This class represents each block or square in the three dimensional matrix</p>
 */
public class Coordinate {

	private int x; 
	private int y;
	private int z;
	
	/**
	 * <p>
	 * Constructor. 
	 * The minimum value for each value is {@link Constraints#MIN_SIZE_PER_DIMENSION}<br/>
	 * The maximum value for each value is {@link Constraints#MAX_SIZE_PER_DIMENSION}
	 * </p>
	 * @param x Value in X axis
	 * @param y Value in Y axis
	 * @param z Value in Z axis
	 */
	public Coordinate(
			@Max(Constraints.MAX_SIZE_PER_DIMENSION)
			@Min(Constraints.MIN_SIZE_PER_DIMENSION)
			int x,
			@Max(Constraints.MAX_SIZE_PER_DIMENSION)
			@Min(Constraints.MIN_SIZE_PER_DIMENSION)
			int y,
			@Max(Constraints.MAX_SIZE_PER_DIMENSION)
			@Min(Constraints.MIN_SIZE_PER_DIMENSION)
			int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * @return the x
	 */
	protected int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	protected int getY() {
		return y;
	}

	/**
	 * @return the z
	 */
	protected int getZ() {
		return z;
	}

	/**
	 * @param x the x to set
	 */
	protected void setX(int x) {
		this.x = x;
	}

	/**
	 * @param y the y to set
	 */
	protected void setY(int y) {
		this.y = y;
	}

	/**
	 * @param z the z to set
	 */
	protected void setZ(int z) {
		this.z = z;
	}
}
