package com.msc.karg

class TestHelloPrinter : Test() {

    override fun registerTestFunctions() {
        registerTestFunction(this::testHelloPrinter)
    }

    fun testHelloPrinter() {
        assertEquals("Hello", "Hello");
    }
}