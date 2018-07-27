package com.msc.karg

class TestSuite(val tests: List<Test>) {
    private val statistics = TestStatistics()

    init {
        for (test in tests) {
            test.setTestSuite(this)
        }
    }

    fun run() {
        for (test in tests) {
            test.run()
        }

        statistics.printResult()

        if (statistics.failuresExist()) {
            //Little hack to be able to return a non-zero error if any tests failed
            throw TestFailure()
        }

    }

    internal fun addFailure() {
        statistics.addFailure()
    }

    internal fun addSuccess() {
        statistics.addSuccess()
    }
}