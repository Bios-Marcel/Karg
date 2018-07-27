package com.msc.karg

class TestStatistics() {

    private var failedTests = 0
    private var successfulTests = 0

    fun addFailure() {
        failedTests++
    }

    fun addSuccess() {
        successfulTests++
    }

    fun failuresExist() = failedTests > 0

    fun printResult() {
        println("-----------------------------------------------------")
        println("Tests failed:     $failedTests")
        println("Tests successful: $successfulTests")
        println("-----------------------------------------------------")
    }
}