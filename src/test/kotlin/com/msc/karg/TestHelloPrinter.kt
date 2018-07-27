package com.msc.karg

object TestHelloPrinter: Test(){

	override fun run() {
		testHelloPrinter()
	}
	
	fun testHelloPrinter() {
	    assertEquals("Example", "Hello", "Hello");
	}
}