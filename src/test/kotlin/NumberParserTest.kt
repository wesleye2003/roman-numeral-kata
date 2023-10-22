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

        assertThat(singleLetterError).isInstanceOf(Error::class.java)
        assertThat(singleLetterError.message).isEqualTo("Invalid Number String")
        assertThat(capitalWordError).isInstanceOf(Error::class.java)
        assertThat(capitalWordError.message).isEqualTo("Invalid Number String")
        assertThat(lowercaseWordError).isInstanceOf(Error::class.java)
        assertThat(lowercaseWordError.message).isEqualTo("Invalid Number String")
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
    fun `parseIntFromRomanNumerals converts multi character roman numerals to Ints correctly`() {
        assertThat(NumberParser.parseIntFromRomanNumerals("II")).isEqualTo(2)
    }

    @Test
    fun `parseIntFromRomanNumerals converts complicated multi character roman numerals to Ints correctly`() {
        assertThat(NumberParser.parseIntFromRomanNumerals("IV")).isEqualTo(4)
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