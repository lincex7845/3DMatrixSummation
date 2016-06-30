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
	private List<CubeSummationTestCase> cubeSummationTests;

	/**
	 * Constructor by default
	 */
	public CubeSummationRequest(){
		//empty
	}
	
	/**
	 * @param cubeSummationTests
	 */
	public CubeSummationRequest(List<CubeSummationTestCase> cubeSummationTests) {
		this.cubeSummationTests = cubeSummationTests;
	}

	/**
	 * @return the cubeSummationTest
	 */
	public List<CubeSummationTestCase> getCubeSummationTests() {
		return cubeSummationTests;
	}

	/**
	 * @param cubeSummationTest the cubeSummationTest to set
	 */
	public void setCubeSummationTests(List<CubeSummationTestCase> cubeSummationTests) {
		this.cubeSummationTests = cubeSummationTests;
	}
	
}
