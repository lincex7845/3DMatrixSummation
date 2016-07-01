/**
 * 
 */
package com.mera.cubeSummation.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import io.dropwizard.Configuration;
import io.dropwizard.testing.junit.DropwizardAppRule;

import org.apache.commons.lang3.StringUtils;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mera.cubeSummation.ApiEntryPoint;
import com.mera.cubeSummation.entity.CubeSummationTestCase;
import com.mera.cubeSummation.entity.CubeSummationRequest;
import com.mera.cubeSummation.entity.CubeSummationResponse;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * @author DavidCamilo
 *
 */
public class CubseSummationServiceIntegrationTest {

	// Uncomment the line below when you are running tests with JUnit
	// private static final String CONFIGURATION_FILE =
	// "cube-summation-configuration.yml";

	// Uncomment the line below when you are running tests with maven
	private static final String CONFIGURATION_FILE = "../cube-summation-configuration.yml";

	@ClassRule
	public static final DropwizardAppRule<Configuration> RULE = new DropwizardAppRule<Configuration>(
			ApiEntryPoint.class, CONFIGURATION_FILE);

	private static Client CLIENT;

	private static Gson GSON;

	private static String CUBE_SUMMATION_URL;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		CLIENT = new Client();
		GSON = new GsonBuilder().create();
		CUBE_SUMMATION_URL = String.format("http://localhost:%d/cubesummation",
				RULE.getLocalPort());
	}

	/**
	 * Test method for
	 * {@link com.mera.cubeSummation.service.CubeSummationService#getCubeSummation(com.mera.cubeSummation.entity.CubeSummationRequest)}
	 * .
	 */
	@Test
	public void testGetCubeSummation() {

		List<CubeSummationTestCase> cubeSummationTests = new ArrayList<>();
		cubeSummationTests.add(new CubeSummationTestCase(4, new String[] {
				"UPDATE 2 2 2 4", "QUERY 1 1 1 3 3 3", "UPDATE 1 1 1 23",
				"QUERY 2 2 2 4 4 4", "QUERY 1 1 1 3 3 3" }));
		cubeSummationTests.add(new CubeSummationTestCase(2, new String[] {
				"UPDATE 2 2 2 1", "QUERY 1 1 1 1 1 1", "QUERY 1 1 1 2 2 2",
				"QUERY 2 2 2 2 2 2" }));
		CubeSummationRequest requestCubeSummation = new CubeSummationRequest(
				cubeSummationTests);
		WebResource resource = CLIENT.resource(CUBE_SUMMATION_URL);
		ClientResponse response = resource
				.type(MediaType.APPLICATION_JSON_TYPE).post(
						ClientResponse.class, requestCubeSummation);
		int status = response.getStatus();
		assertEquals(200, status);
		String entity = response.getEntity(String.class);
		assertFalse(StringUtils.isBlank(entity));
		System.out.println(entity);
		CubeSummationResponse responseCubeSummation = GSON.fromJson(entity,
				CubeSummationResponse.class);
		assertNotNull(responseCubeSummation);

	}
}
