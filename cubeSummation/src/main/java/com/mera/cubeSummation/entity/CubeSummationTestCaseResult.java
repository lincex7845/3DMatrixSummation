/**
 * 
 */
package com.mera.cubeSummation.entity;

import java.util.List;

/**
 * @author DavidCamilo
 *         <p>
 *         A POJO which represents the performed test case
 *         </p>
 */
public class CubeSummationTestCaseResult {

	private List<CubeSummationOperation> operationResults;
	
	/**
	 * Constructor by default
	 */
	public CubeSummationTestCaseResult() {
		// empty
	}
	
	/**
	 * 
	 * @param operationResults
	 */
	public CubeSummationTestCaseResult(List<CubeSummationOperation> operationResults){
		this.operationResults = operationResults;
	}

	/**
	 * @return the operationResults
	 */
	public List<CubeSummationOperation> getOperationResults() {
		return operationResults;
	}

	/**
	 * @param operationResults the operationResults to set
	 */
	public void setOperationResults(List<CubeSummationOperation> operationResults) {
		this.operationResults = operationResults;
	}

}