package com.msc.karg

/**
 * Abstract class for classes that contain tests, it simply provides a function to run them all
 * and some assertions functions.
 *
 * @author Marcel
 * @since 25.07.2018
 */
abstract class Test {

    private lateinit var testSuite: TestSuite

    private val tests = mutableListOf<() -> Unit>()

    init {
        registerTestFunctions()
    }

    /**
     * Runs all tests in this class.
     */
    fun run() {
        for (test in tests) {
            try {
                test.invoke()
                testSuite.addSuccess()
            } catch (exception: Exception) {
                exception.printStackTrace()
                testSuite.addFailure()
            }
        }
    }

    /**
     * Point at which all test functions should be registers via [registerTestFunction]
     */
    abstract fun registerTestFunctions()

    /**
     * @param[testFunction] function that should be registered as a test function
     */
    protected fun registerTestFunction(testFunction: () -> Unit) {
        tests.add(testFunction)
    }

    internal fun setTestSuite(testSuite: TestSuite) {
        this.testSuite = testSuite
    }

    /**
     * Compares two values with each other. If the two values aren't equal, a message will be printed
     * that tells the Testname and the result, addionally the app will stop executing with an errorcode.
     *
     * @param[testName] the name of the test, neccessary for identification by the developer
     * @param[expected] the correct value
     * @param[actual] the actual value
     */
    @Suppress("NOTHING_TO_INLINE")
    inline fun assertEquals(expected: Any?, actual: Any?, testName: String? = null) {
        if (expected != actual) {
            printFailure(testName, "Expected '$expected', but was '$actual'.")
            //Instead of simply exiting manually, i use an exception, in order to avoid target-dependant code
            throw com.msc.karg.TestFailure()
        }
    }

    @Suppress("NOTHING_TO_INLINE")
    inline fun fail() {
        printFailure("FORCED FAILURE", "This test failed due to a call to Test#fail")
        throw com.msc.karg.TestFailure()
    }

    @Suppress("NOTHING_TO_INLINE")
    inline fun printFailure(testName: String?, text: String) {
        val testNameToPrint = if(testName != null) "-$testName" else ""
        println("FAILURE in ${this::class.simpleName}$testNameToPrint: $text")
    }
}