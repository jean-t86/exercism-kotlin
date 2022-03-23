import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class ScrabbleScoreTest {
    companion object {
        @JvmStatic
        fun data() = listOf(
            arrayOf("a", 1),
            arrayOf("A", 1),
            arrayOf("f", 4),
            arrayOf("at", 2),
            arrayOf("zoo", 12),
            arrayOf("street", 6),
            arrayOf("quirky", 22),
            arrayOf("OxyphenButazone", 41),
            arrayOf("pinata", 8),
            arrayOf("", 0),
            arrayOf("abcdefghijklmnopqrstuvwxyz", 87)
        )
    }

    @ParameterizedTest(name = "{index}: scoreWord({0})={1}")
    @MethodSource("data")
    fun test(input: String, expectedOutput: Int) {
        assertEquals(expectedOutput, ScrabbleScore.scoreWord(input))
    }
}
