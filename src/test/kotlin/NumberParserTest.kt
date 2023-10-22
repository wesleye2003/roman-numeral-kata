import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class NumberParserTest {
    @Test
    fun `Single character roman numerals are converted to Ints correctly`() {
        assertThat(NumberParser.parseIntFromRomanNumerals("I")).isEqualTo(1)
        assertThat(NumberParser.parseIntFromRomanNumerals("V")).isEqualTo(5)
        assertThat(NumberParser.parseIntFromRomanNumerals("X")).isEqualTo(10)
        assertThat(NumberParser.parseIntFromRomanNumerals("L")).isEqualTo(50)
        assertThat(NumberParser.parseIntFromRomanNumerals("C")).isEqualTo(100)
        assertThat(NumberParser.parseIntFromRomanNumerals("D")).isEqualTo(500)
        assertThat(NumberParser.parseIntFromRomanNumerals("M")).isEqualTo(1000)
    }

    @Test
    fun `Standard multi character roman numerals are converted to Ints correctly`() {
        assertThat(NumberParser.parseIntFromRomanNumerals("II")).isEqualTo(2)
    }

    @Test
    fun `Complicated multi character roman numerals are converted to Ints correctly`() {
        assertThat(NumberParser.parseIntFromRomanNumerals("IV")).isEqualTo(4)
    }

    @Test
    fun `Ints are converted to single character roman numerals correctly`() {
        assertThat(NumberParser.parseRomanNumeralsFromInt(1)).isEqualTo("I")
    }

    @Test
    fun `Ints are converted to simple multi character roman numerals correctly`() {
        assertThat(NumberParser.parseRomanNumeralsFromInt(2)).isEqualTo("II")
    }

    @Test
    fun `Ints are converted to complex multi character roman numerals correctly`() {
        assertThat(NumberParser.parseRomanNumeralsFromInt(4)).isEqualTo("IV")
    }
}