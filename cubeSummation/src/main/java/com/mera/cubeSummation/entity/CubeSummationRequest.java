/**
 * 
 */
package com.mera.cubeSummation.entity;

import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.mera.cubeSummation.commons.Constraints;

/**
 * @author DavidCamilo
 * <p>A POJO which represents the HTTP request body</p>
 */
public class CubeSummationRequest {

	@NotEmpty 
	@Size(max=Constraints.MAX_NUMBER_OF_TEST) 
	private List<CubeSummationOperation> cubeSummationTests;

	/**
	 * @param cubeSummationTests
	 */
	public CubeSummationRequest(List<CubeSummationOperation> cubeSummationTests) {
		this.cubeSummationTests = cubeSummationTests;
	}

	/**
	 * @return the cubeSummationTest
	 */
	public List<CubeSummationOperation> getCubeSummationTest() {
		return cubeSummationTests;
	}

	/**
	 * @param cubeSummationTest the cubeSummationTest to set
	 */
	public void setCubeSummationTests(List<CubeSummationOperation> cubeSummationTests) {
		this.cubeSummationTests = cubeSummationTests;
	}
	
}
