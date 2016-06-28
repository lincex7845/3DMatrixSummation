/**
 * 
 */
package com.mera.cubeSummation.dao;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.mera.cubeSummation.commons.Constraints;
import com.mera.cubeSummation.entity.Cube;

/**
 * @author DavidCamilo
 *         <p>
 *         This interface represents a set of operations to be performed against
 *         any {@link Cube}
 *         </p>
 */
public interface ICubeDAO {

	public static final String BLANK_SPACE = " ";
	
	/**
	 * This operation updates the value of the given block in the given cube
	 * 
	 * @param updateCommand
	 *            A string which follows the pattern
	 *            {@link Constraints#UPDATE_OPERATION_PATTERN}
	 */
	public void updateBlockValue(
			@NotBlank @Pattern(regexp = Constraints.UPDATE_OPERATION_PATTERN) String updateCommand);

	/**
	 * This method gets the summation between two blocks
	 * 
	 * @param queryCommand
	 *            A string which follows the pattern
	 *            {@link Constraints.QUERY_OPERATION_PATTERN}
	 *
	 * @return The summation between two block. The start and end block are both
	 *         included
	 */
	public long querySummatoryBetweenBlocks(
			@NotBlank @Pattern(regexp = Constraints.QUERY_OPERATION_PATTERN) String queryCommand);
}
