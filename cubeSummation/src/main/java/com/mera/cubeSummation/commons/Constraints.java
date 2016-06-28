/**
 * 
 */
package com.mera.cubeSummation.commons;

/**
 * @author DavidCamilo
 * <p>A set of common constraints to handle data in the matrix</p>
 */
public final class Constraints {
	
	/**
	 * The maximum number of test to be performed: 50
	 */
	public static final int MAX_NUMBER_OF_TEST = 0x32;
	
	/**
	 * The maximum number of blocks per dimension: 100
	 */
	public static final int MAX_SIZE_PER_DIMENSION = 0x64;
	
	/**
	 * The maximum number of operations to be performed in each test: 1000
	 */
	public static final int MAX_NUMBER_OF_OPERATIONS = 1000;
	
	/**
	 * The maximum number to be stored in each block: 10 <sup>9</sup>
	 */
	public static final int MAX_VALUE_IN_BLOCK = 0x3B9ACA00;
	
	/**
	 * The minimum value to be stored in each block: -10 <sup>9</sup>
	 */
	public static final int MIN_VALUE_IN_BLOCK = -MAX_VALUE_IN_BLOCK;
	
	/**
	 * The pattern of the update operation: <i>UPDATE x y z W</i>
	 */
	public static final String UPDATE_OPERATION_PATTERN = "(?)^UPDATE\\s\\d\\s\\d\\s\\d\\s\\d";
	
	/**
	 * The pattern of query operation: <i>QUERY x1 y1 z1 x2 y2 z2</i>
	 */
	public static final String QUERY_OPERATION_PATTERN = "(?)^QUERY\\s\\d\\s\\d\\s\\d\\s\\d\\s\\d\\s\\d";

	/**
	 * The minimum number of test cases to be performed (1)
	 */
	public static final int ONE = 1;
	
	/**
	 * Constructor by default
	 */
	private Constraints(){
		// empty
	}
}
