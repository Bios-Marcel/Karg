package com.msc.karg

/**
 * Abstract class for classes that contain tests, it simply provides a function to run them all
 * and some assertions functions.
 *
 * @author Marcel
 * @since 25.07.2018 
 */
abstract class Test {
	/**
	 * Runs all tests in this class.
	 */
	abstract fun run()

    /**
     * Compares two values with each other. If the two values aren't equal, a message will be printed
     * that tells the Testname and the result, addionally the app will stop executing with an errorcode.
     * 
     * @param[testName] the name of the test, neccessary for identification by the developer
     * @param[expected] the correct value
     * @param[actual] the actual value
     */
	inline fun assertEquals(testName: String, expected: Any?, actual: Any?) {
	    if(expected != actual) {
	        println("FAILURE in ${this::class.qualifiedName}-$testName: Expected '$expected', but was '$actual'.")
	        //Instead of simply exiting manually, i use an exception, in order to avoid target-dependant code
            throw TestFailure()
	    } 
	}
}

/**
 * Simple [Exception] to be thrown if a unit tets fails.
 *
 * @author Marcel
 * @since 27.07.2018
 */
class TestFailure: Exception()