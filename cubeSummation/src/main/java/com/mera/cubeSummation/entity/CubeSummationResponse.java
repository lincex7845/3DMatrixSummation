/**
 * 
 */
package com.mera.cubeSummation.entity;

import java.util.List;

/**
 * @author DavidCamilo
 * <p>A POJO which represents the HTTP response body</p>
 */
public class CubeSummationResponse {

	/**
	 * The code status of HTTP response
	 */
	private int messageStatus;
	
	/**
	 * The description of HTTP response status
	 */
	private String messageDescription;
	
	/**
	 * The list of all results of the operations performed in each test case
	 */
	private List<CubeSummationTestCaseResult> cubeSummationTestResults;
	
	/**
	 * Constructor by default
	 */
	public CubeSummationResponse(){
		//empty
	}

	/**
	 * @param messageStatus
	 * @param messageDescription
	 * @param cubeSummationTestResults
	 */
	public CubeSummationResponse(int messageStatus, String messageDescription,
			List<CubeSummationTestCaseResult> cubeSummationTestResults) {
		this.messageStatus = messageStatus;
		this.messageDescription = messageDescription;
		this.cubeSummationTestResults = cubeSummationTestResults;
	}

	/**
	 * @return the messageStatus
	 */
	public int getMessageStatus() {
		return messageStatus;
	}

	/**
	 * @return the messageDescription
	 */
	public String getMessageDescription() {
		return messageDescription;
	}

	/**
	 * @return the operationResults
	 */
	public List<CubeSummationTestCaseResult> getCubeSummationTestResults() {
		return cubeSummationTestResults;
	}

	/**
	 * @param messageStatus the messageStatus to set
	 */
	public void setMessageStatus(int messageStatus) {
		this.messageStatus = messageStatus;
	}

	/**
	 * @param messageDescription the messageDescription to set
	 */
	public void setMessageDescription(String messageDescription) {
		this.messageDescription = messageDescription;
	}

	/**
	 * @param operationResults the operationResults to set
	 */
	public void setCubeSummationTestResults(List<CubeSummationTestCaseResult> cubeSummationTestResults) {
		this.cubeSummationTestResults = cubeSummationTestResults;
	}
}
