
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class PhoneNumberTest {
    @Test
    fun `valid | simple number`() = assertNumberEquals("(223) 456-7890", "2234567890")

    @Test
    fun `valid | number with dots`() = assertNumberEquals("223.456.7890", "2234567890")

    @Test
    fun `valid | numbers with multiple spaces`() = assertNumberEquals("223 456   7890   ", "2234567890")

    @Test
    fun `invalid | 9 digit`() {
        assertThrows<IllegalArgumentException> {
            PhoneNumber("123456789")
        }
    }

    @Test
    fun `invalid | when 11 digits does not start with a 1`() {
        assertThrows<IllegalArgumentException> {
            PhoneNumber("22234567890")
        }
    }

    @Test
    fun `valid | 11 digits and starting with 1`() = assertNumberEquals("12234567890", "2234567890")

    @Test
    fun `valid | 11 digits starting with 1 with punctuation`() = assertNumberEquals("+1 (223) 456-7890", "2234567890")

    fun `invalid | more than 11 digits`() {
        assertThrows<IllegalArgumentException> {
            PhoneNumber("321234567890")
        }
    }

    @Test
    fun `invalid | letters`() {
        assertThrows<IllegalArgumentException> {
            PhoneNumber("123-abc-7890")
        }
    }

    @Test
    fun `invalid | punctuations`() {
        assertThrows<IllegalArgumentException> {
            PhoneNumber("123-@:!-7890")
        }
    }

    @Test
    fun `invalid | area code starts with 0`() {
        assertThrows<IllegalArgumentException> {
            PhoneNumber("(023) 456-7890")
        }
    }

    @Test
    fun `invalid | area code starts with 1`() {
        assertThrows<IllegalArgumentException> {
            PhoneNumber("(123) 456-7890")
        }
    }

    @Test
    fun `invalid | exchange code starts with 0`() {
        assertThrows<IllegalArgumentException> {
            PhoneNumber("(223) 056-7890")
        }
    }

    @Test
    fun `invalid | exchange code starts with 1`() {
        assertThrows<IllegalArgumentException> {
            PhoneNumber("(223) 156-7890")
        }
    }

    @Test
    fun `invalid | area code starts with 0 on valid 11-digit number`() {
        assertThrows<IllegalArgumentException> {
            PhoneNumber("1 (023) 456-7890")
        }
    }

    @Test
    fun `invalid | area code starts with 1 on valid 11-digit number`() {
        assertThrows<IllegalArgumentException> {
            PhoneNumber("1 (123) 456-7890")
        }
    }

    @Test
    fun `invalid | exchange code starts with 0 on valid 11-digit number`() {
        assertThrows<IllegalArgumentException> {
            PhoneNumber("1 (223) 056-7890")
        }
    }

    @Test
    fun `invalid | exchange code starts with 1 on valid 11-digit number`() {
        assertThrows<IllegalArgumentException> {
            PhoneNumber("1 (223) 156-7890")
        }
    }
}

private fun assertNumberEquals(input: String, expectation: String) =
    assertEquals(expectation, PhoneNumber(input).number)
