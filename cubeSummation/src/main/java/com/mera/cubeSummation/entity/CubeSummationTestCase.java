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
public class CubeSummationTestCase {
	
	private static final String MESSAGE_ERROR_DIMENSION_SIZE = "The number of blocks per dimension must be between 1 and 100";
	
	private static final String MESSAGE_ERROR_OPERATIONS_SIZE = "The number of operations to execute must be between 1 and 1000";

	@Max(value=Constraints.MAX_SIZE_PER_DIMENSION, message=MESSAGE_ERROR_DIMENSION_SIZE)
	@Min(value=Constraints.ONE, message=MESSAGE_ERROR_DIMENSION_SIZE)
	private int numberOfBlocksPerDimension;

	@NotEmpty(message=MESSAGE_ERROR_OPERATIONS_SIZE)
	@Size(max = Constraints.MAX_NUMBER_OF_OPERATIONS, message=MESSAGE_ERROR_OPERATIONS_SIZE)
	private String[] operations;
	
	/**
	 * Constructor by default
	 */
	public CubeSummationTestCase(){
		//empty
	}

	/**
	 * @param numberOfBlocksPerDimension
	 * @param operations
	 */
	public CubeSummationTestCase(int numberOfBlocksPerDimension,
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
