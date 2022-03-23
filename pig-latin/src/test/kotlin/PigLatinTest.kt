import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class PigLatinTest {

    companion object {
        @JvmStatic
        fun data() = arrayOf(
                // Ay is added to words that start with vowels
                arrayOf("apple",  "appleay"),
                arrayOf("ear",    "earay"),
                arrayOf("igloo",  "iglooay"),
                arrayOf("object", "objectay"),
                arrayOf("under",  "underay"),

                // Ay is added to words that start with vowels followed by qu
                arrayOf("equal",  "equalay"),

                // First letter and ay are moved to the end of words that start with consonants
                arrayOf("pig",    "igpay"),
                arrayOf("koala",  "oalakay"),
                arrayOf("xenon",  "enonxay"),
                arrayOf("qat",    "atqay"),

                // Ch is treated like a single consonant
                arrayOf("chair", "airchay"),

                // Qu is treated like a single consonant
                arrayOf("queen", "eenquay"),

                // Qu and a single preceding consonant are treated like a single consonant
                arrayOf("square", "aresquay"),

                // Th is treated like a single consonant
                arrayOf("therapy", "erapythay"),

                // Thr is treated like a single consonant
                arrayOf("thrush", "ushthray"),

                // Sch is treated like a single consonant
                arrayOf("school", "oolschay"),

                // Yt is treated like a single vowel
                arrayOf("yttria", "yttriaay"),

                // Xr is treated like a single vowel
                arrayOf("xray", "xrayay"),

                // Y is treated like a consonant at the beginning of a word
                arrayOf("yellow", "ellowyay"),

                // Y is treated like a vowel at the end of a consonant cluster
                arrayOf("rhythm", "ythmrhay"),

                // Y as second letter in two letter word
                arrayOf("my",     "ymay"),

                // Phrases are translated
                arrayOf("quick fast run", "ickquay astfay unray")
        )
    }

    @ParameterizedTest(name = "{index}: translate({0})={1}")
    @MethodSource("data")
    fun test(input: String, expectedOutput: String) {
        assertEquals(expectedOutput, PigLatin.translate(input))
    }

}
