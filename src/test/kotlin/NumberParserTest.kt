import org.junit.jupiter.api.Test

class NumberParserTest {
    @Test
    fun `Test single character roman numerals are converted to Ints correctly`() {
        assert(NumberParser.parseIntFromRomanNumerals("I") == 1)
    }

    @Test
    fun `Test standard multi character roman numerals are converted to Ints correctly`() {
        assert(NumberParser.parseIntFromRomanNumerals("II") == 2)
    }

    @Test
    fun `Test complicated multi character roman numerals are converted to Ints correctly`() {
        assert(NumberParser.parseIntFromRomanNumerals("IV") == 4)
    }

    @Test
    fun `Test Ints are converted to single character roman numerals correctly`() {
        assert(NumberParser.parseRomanNumeralsFromInt(1) == "I")
    }

    @Test
    fun `Test Ints are converted to simple multi character roman numerals correctly`() {
        assert(NumberParser.parseRomanNumeralsFromInt(2) == "II")
    }

    @Test
    fun `Test Ints are converted to complex multi character roman numerals correctly`() {
        assert(NumberParser.parseRomanNumeralsFromInt(4) == "IV")
    }
}