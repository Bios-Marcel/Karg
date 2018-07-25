package com.msc.karg

object TestHelloPrinter: Test {

	override fun run() {
		testHelloPrinter()
	}
	
	fun testHelloPrinter() {
		assert("Hello".equals(HelloPrinter.returnHello()))		
	}
}