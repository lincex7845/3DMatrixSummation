/**
 * 
 */
package com.mera.cubeSummation.entity;

/**
 * 
 * @author DavidCamilo
 *         <p>
 *         A POJO which represents each performed operation in a test case
 *         </p>
 */
public class CubeSummationOperation {

	/**
	 * The performed operation
	 */
	private String operation;

	/**
	 * The result of the performed operation
	 */
	private String result;

	/**
	 * Constructor by default
	 */
	public CubeSummationOperation() {
		// empty
	}

	/**
	 * @param operation
	 * @param result
	 */
	public CubeSummationOperation(String operation, String result) {
		this.operation = operation;
		this.result = result;
	}

	/**
	 * @return the operation
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param operation
	 *            the operation to set
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}
}