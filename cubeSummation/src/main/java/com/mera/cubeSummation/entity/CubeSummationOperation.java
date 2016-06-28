/**
 * 
 */
package com.mera.cubeSummation.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.mera.cubeSummation.commons.Constraints;

/**
 * @author DavidCamilo
 *         <p>
 *         A POJO which represents each test case of cube summation
 *         </p>
 */
public class CubeSummationOperation {

	@Max(Constraints.MAX_SIZE_PER_DIMENSION)
	@Min(Constraints.ONE)
	private int numberOfBlocksPerDimension;

	@NotEmpty
	@Size(max = Constraints.MAX_NUMBER_OF_OPERATIONS)
	private String[] operations;

	/**
	 * @param numberOfBlocksPerDimension
	 * @param operations
	 */
	public CubeSummationOperation(int numberOfBlocksPerDimension,
			String[] operations) {
		this.numberOfBlocksPerDimension = numberOfBlocksPerDimension;
		this.operations = operations;
	}

	/**
	 * @return the numberOfBlockPerDimension
	 */
	public int getNumberOfBlocksPerDimension() {
		return numberOfBlocksPerDimension;
	}
	
	/**
	 * @return the operations
	 */
	public String[] getOperations() {
		return operations;
	}

	/**
	 * @param numberOfBlockPerDimension
	 *            the numberOfBlockPerDimension to set
	 */
	public void setNumberOfBlocksPerDimension(int numberOfBlocksPerDimension) {
		this.numberOfBlocksPerDimension = numberOfBlocksPerDimension;
	}

	/**
	 * @param operations
	 *            the operations to set
	 */
	public void setOperations(String[] operations) {
		this.operations = operations;
	}
}
