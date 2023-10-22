import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows

class NumberParserTest {
    @Test
    fun `parseIntFromRomanNumerals converts single character roman numerals to Ints correctly`() {
        assertThat(NumberParser.parseIntFromRomanNumerals("I")).isEqualTo(1)
        assertThat(NumberParser.parseIntFromRomanNumerals("V")).isEqualTo(5)
        assertThat(NumberParser.parseIntFromRomanNumerals("X")).isEqualTo(10)
        assertThat(NumberParser.parseIntFromRomanNumerals("L")).isEqualTo(50)
        assertThat(NumberParser.parseIntFromRomanNumerals("C")).isEqualTo(100)
        assertThat(NumberParser.parseIntFromRomanNumerals("D")).isEqualTo(500)
        assertThat(NumberParser.parseIntFromRomanNumerals("M")).isEqualTo(1000)
    }

    @Test
    fun `parseIntFromRomanNumerals converts multi character roman numerals to Ints correctly`() {
        assertThat(NumberParser.parseIntFromRomanNumerals("II")).isEqualTo(2)
        assertThat(NumberParser.parseIntFromRomanNumerals("II")).isEqualTo(2)
    }

    @Test
    fun `parseIntFromRomanNumerals converts complicated multi character roman numerals to Ints correctly`() {
        assertThat(NumberParser.parseIntFromRomanNumerals("IV")).isEqualTo(4)
        assertThat(NumberParser.parseIntFromRomanNumerals("CMXCIX")).isEqualTo(999)
        assertThat(NumberParser.parseIntFromRomanNumerals("MMCCCLXXII")).isEqualTo(2372)
    }

    @Test
    fun `parseIntFromRomanNumerals is not case sensitive`() {
        assertThat(NumberParser.parseIntFromRomanNumerals("i")).isEqualTo(1)
        assertThat(NumberParser.parseIntFromRomanNumerals("v")).isEqualTo(5)
        assertThat(NumberParser.parseIntFromRomanNumerals("x")).isEqualTo(10)
        assertThat(NumberParser.parseIntFromRomanNumerals("l")).isEqualTo(50)
        assertThat(NumberParser.parseIntFromRomanNumerals("c")).isEqualTo(100)
        assertThat(NumberParser.parseIntFromRomanNumerals("d")).isEqualTo(500)
        assertThat(NumberParser.parseIntFromRomanNumerals("m")).isEqualTo(1000)
    }

    @Test
    fun `parseIntFromRomanNumerals throws errors for invalid strings`() {
        val singleLetterError = assertThrows<Error> {
            NumberParser.parseIntFromRomanNumerals("A")
        }
        val capitalWordError = assertThrows<Error> {
            NumberParser.parseIntFromRomanNumerals("Test")
        }
        val lowercaseWordError = assertThrows<Error> {
            NumberParser.parseIntFromRomanNumerals("string")
        }
        val invalidFifteenError = assertThrows<Error> {
            NumberParser.parseIntFromRomanNumerals("VVV")
        }
        val invalidOneHundredFiftyError = assertThrows<Error> {
            NumberParser.parseIntFromRomanNumerals("LLL")
        }
        val invalidFifteenHundredError = assertThrows<Error> {
            NumberParser.parseIntFromRomanNumerals("DDD")
        }
        val invalidFiveError = assertThrows<Error> {
            NumberParser.parseIntFromRomanNumerals("VX")
        }
        val invalidNineHundredNinetyFiveError = assertThrows<Error> {
            NumberParser.parseIntFromRomanNumerals("VM")
        }
        val invalidFiftyError = assertThrows<Error> {
            NumberParser.parseIntFromRomanNumerals("LC")
        }
        val invalidNineHundredNinetyNineError = assertThrows<Error> {
            NumberParser.parseIntFromRomanNumerals("IM")
        }
        val invalidFortyNineError = assertThrows<Error> {
            NumberParser.parseIntFromRomanNumerals("IL")
        }

        assertThat(singleLetterError).isInstanceOf(Error::class.java)
        assertThat(singleLetterError.message).isEqualTo("Invalid Number String")

        assertThat(capitalWordError).isInstanceOf(Error::class.java)
        assertThat(capitalWordError.message).isEqualTo("Invalid Number String")

        assertThat(lowercaseWordError).isInstanceOf(Error::class.java)
        assertThat(lowercaseWordError.message).isEqualTo("Invalid Number String")

        assertThat(invalidFifteenError).isInstanceOf(Error::class.java)
        assertThat(invalidFifteenError.message).isEqualTo("Invalid Number String")

        assertThat(invalidOneHundredFiftyError).isInstanceOf(Error::class.java)
        assertThat(invalidOneHundredFiftyError.message).isEqualTo("Invalid Number String")

        assertThat(invalidFifteenHundredError).isInstanceOf(Error::class.java)
        assertThat(invalidFifteenHundredError.message).isEqualTo("Invalid Number String")

        assertThat(invalidFiveError).isInstanceOf(Error::class.java)
        assertThat(invalidFiveError.message).isEqualTo("Invalid Number String")

        assertThat(invalidNineHundredNinetyFiveError).isInstanceOf(Error::class.java)
        assertThat(invalidNineHundredNinetyFiveError.message).isEqualTo("Invalid Number String")

        assertThat(invalidFiftyError).isInstanceOf(Error::class.java)
        assertThat(invalidFiftyError.message).isEqualTo("Invalid Number String")

        assertThat(invalidNineHundredNinetyNineError).isInstanceOf(Error::class.java)
        assertThat(invalidNineHundredNinetyNineError.message).isEqualTo("Invalid Number String")

        assertThat(invalidFortyNineError).isInstanceOf(Error::class.java)
        assertThat(invalidFortyNineError.message).isEqualTo("Invalid Number String")
    }

    @Test
    fun `parseRomanNumeralsFromInt converts Ints to single character roman numerals correctly`() {
        assertThat(NumberParser.parseRomanNumeralsFromInt(1)).isEqualTo("I")
    }

    @Test
    fun `parseRomanNumeralsFromInt converts Ints to simple multi character roman numerals correctly`() {
        assertThat(NumberParser.parseRomanNumeralsFromInt(2)).isEqualTo("II")
    }

    @Test
    fun `parseRomanNumeralsFromInt converts Ints to complex multi character roman numerals correctly`() {
        assertThat(NumberParser.parseRomanNumeralsFromInt(4)).isEqualTo("IV")
    }
}