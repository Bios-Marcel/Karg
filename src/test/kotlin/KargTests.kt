import com.msc.karg.TestSuite

fun main(arguments: Array<String>) {
    TestSuite(listOf(
        com.msc.karg.TestHelloPrinter()
    )).run()
}