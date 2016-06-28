/**
 * 
 */
package com.mera.cubeSummation.entity;

import java.util.Map;

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
	 * The result map of the performed operations against the cube
	 */
	private Map<String, String> operationResults;

	/**
	 * @param messageStatus
	 * @param messageDescription
	 * @param operationResults
	 */
	public CubeSummationResponse(int messageStatus, String messageDescription,
			Map<String, String> operationResults) {
		this.messageStatus = messageStatus;
		this.messageDescription = messageDescription;
		this.operationResults = operationResults;
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
	public Map<String, String> getOperationResults() {
		return operationResults;
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
	public void setOperationResults(Map<String, String> operationResults) {
		this.operationResults = operationResults;
	}
}
