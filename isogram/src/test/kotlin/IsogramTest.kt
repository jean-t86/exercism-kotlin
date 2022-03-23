import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class IsogramTest {
    companion object {
        @JvmStatic
        fun data() = listOf(
                arrayOf("", true),
                arrayOf("isogram", true),
                arrayOf("eleven", false),
                arrayOf("zzyzx", false),
                arrayOf("subdermatoglyphic", true),
                arrayOf("Alphabet", false),
                arrayOf("alphAbet", false),
                arrayOf("thumbscrew-japingly", true),
                arrayOf("thumbscrew-jappingly", false),
                arrayOf("six-year-old", true),
                arrayOf("Emily Jung Schwartzkopf", true),
                arrayOf("accentor", false),
                arrayOf("angola", false)
        )
    }

    @ParameterizedTest(name = "{index}: isogram({0}) = {1})")
    @MethodSource("data")
    fun test(input: String, expectedOutput: Boolean) {
        assertEquals(expectedOutput, Isogram.isIsogram(input))
    }
}
