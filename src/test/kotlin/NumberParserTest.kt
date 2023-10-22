import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class NumberParserTest {
    @Test
    fun `Test single character roman numerals are converted to Ints correctly`() {
        assertThat(NumberParser.parseIntFromRomanNumerals("I")).isEqualTo(1)
    }

    @Test
    fun `Test standard multi character roman numerals are converted to Ints correctly`() {
        assertThat(NumberParser.parseIntFromRomanNumerals("II")).isEqualTo(2)
    }

    @Test
    fun `Test complicated multi character roman numerals are converted to Ints correctly`() {
        assertThat(NumberParser.parseIntFromRomanNumerals("IV")).isEqualTo(4)
    }

    @Test
    fun `Test Ints are converted to single character roman numerals correctly`() {
        assertThat(NumberParser.parseRomanNumeralsFromInt(1)).isEqualTo("I")
    }

    @Test
    fun `Test Ints are converted to simple multi character roman numerals correctly`() {
        assertThat(NumberParser.parseRomanNumeralsFromInt(2)).isEqualTo("II")
    }

    @Test
    fun `Test Ints are converted to complex multi character roman numerals correctly`() {
        assertThat(NumberParser.parseRomanNumeralsFromInt(4)).isEqualTo("IV")
    }
}