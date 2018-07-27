package com.msc.karg

class TestHelloPrinter : Test() {

    override fun registerTestFunctions() {
        registerTestFunction(this::testHelloPrinter)
        registerTestFunction(this::testFailure)
    }

    fun testHelloPrinter() {
        assertEquals("Hello", "Hello");
    }

    fun testFailure() {
        fail()
    }
}