/**
 * 
 */
package com.mera.cubeSummation.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.codahale.metrics.annotation.Timed;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mera.cubeSummation.commons.Constraints;
import com.mera.cubeSummation.dao.CubeDAO;
import com.mera.cubeSummation.dao.ICubeDAO;
import com.mera.cubeSummation.entity.Cube;
import com.mera.cubeSummation.entity.CubeSummationOperation;
import com.mera.cubeSummation.entity.CubeSummationRequest;
import com.mera.cubeSummation.entity.CubeSummationResponse;
import com.mera.cubeSummation.entity.CubeSummationTestCase;
import com.mera.cubeSummation.entity.CubeSummationTestCaseResult;
import com.mera.cubeSummation.util.ValidatorUtil;

/**
 * @author DavidCamilo
 *
 */
@Path("/cubesummation")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CubeSummationService {

	/**
	 * The logger instance
	 */
	private static final Logger LOGGER = Logger
			.getLogger(CubeSummationService.class);

	/**
	 * Used to serialize data to json format
	 */
	private static final Gson GSON = new GsonBuilder().create();

	@POST
	@Timed
	public Response getCubeSummation(@Valid @NotNull CubeSummationRequest request) {

		Response response;
		try {
			request.getCubeSummationTests().forEach(testCase -> ValidatorUtil.validate(testCase));
			int status = Response.Status.OK.getStatusCode();
			List<CubeSummationTestCaseResult> cubeSummationTestResults = new ArrayList<>();
			for (CubeSummationTestCase test : request.getCubeSummationTests()) {
				Cube cube = new Cube(test.getNumberOfBlocksPerDimension());
				ICubeDAO cubeDAO = new CubeDAO(cube);
				List<CubeSummationOperation> operationResults = new ArrayList<>();
				for (int i = 0; i < test.getOperations().length; i++) {
					executeOperation(cubeDAO, test.getOperations()[i],
							operationResults);
				}
				cubeSummationTestResults.add(new CubeSummationTestCaseResult(operationResults));				
			}
			CubeSummationResponse cubeSummationResponse = new CubeSummationResponse(
					status, "Successfully Executed!", cubeSummationTestResults);
			response = Response.status(status)
					.entity(GSON.toJson(cubeSummationResponse)).build();
		} catch (UnsupportedOperationException | ConstraintViolationException | IllegalArgumentException e) {
			response = buildErrorResponse(
					Response.Status.BAD_REQUEST.getStatusCode(), e);
		} catch (Exception e) {
			response = buildErrorResponse(
					Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), e);
		}
		return response;
	}

	/**
	 * This method verifies if the operation can be performed, then, executes
	 * the operation if it is supported.
	 * 
	 * @param cubeDAO
	 *            An instance of {@link ICubeDAO}
	 * @param operation
	 *            The command to be performed
	 * @param operationResults
	 *            The result of command execution
	 */
	private void executeOperation(ICubeDAO cubeDAO, String operation,
			List<CubeSummationOperation> operationResults) {
		
		if (operation.matches(Constraints.QUERY_OPERATION_PATTERN)) {
			operationResults.add(new CubeSummationOperation(operation, Long
					.toString(cubeDAO.querySummatoryBetweenBlocks(operation))));
		} else if (operation.matches(Constraints.UPDATE_OPERATION_PATTERN)) {
			cubeDAO.updateBlockValue(operation);
			operationResults.add(new CubeSummationOperation(operation,
					"Operation successfully executed!"));
		} else {
			throw new UnsupportedOperationException(String.format(
					"The operation %s is not supported", operation));
		}
	}

	/**
	 * This method builds response body when an exception is raised
	 * 
	 * @param statusCode
	 *            The HTTP status code
	 * @param e
	 *            The raised exception
	 * @return The response body which contains the error
	 */
	private Response buildErrorResponse(int statusCode, Exception e) {
		LOGGER.error(e.getMessage(), e);
		int status = statusCode;
		String entity = GSON.toJson(new CubeSummationResponse(status, e
				.getMessage(), null));
		return Response.status(status).entity(entity).build();
	}
}
