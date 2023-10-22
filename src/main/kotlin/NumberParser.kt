object NumberParser {
    private const val numeralOne = "I"
    private const val numeralFive = "V"
    private const val numeralTen = "X"
    private const val numeralFifty = "L"
    private const val numeralOneHundred = "C"
    private const val numeralFiveHundred = "D"
    private const val numeralOneThousand = "M"
    fun parseIntFromRomanNumerals(numString: String): Int {
        // convert simple numerals immediately
        if (numString.length == 1) {
            return convertSimpleNumeralToInt(numString)
        }

        val numeralList = numString.map{it.toString()}.withIndex()
        var finalNumber = 0

        return finalNumber
    }

    fun parseRomanNumeralsFromInt(intToConvert: Int): String {
        return "Test"
    }

    private fun convertSimpleNumeralToInt(numString: String): Int {
        return when (numString) {
            numeralOne -> 1
            numeralFive -> 5
            numeralTen -> 10
            numeralFifty -> 50
            numeralOneHundred -> 100
            numeralFiveHundred -> 500
            numeralOneThousand -> 1000
            else -> throw Error("Invalid Number String")
        }
    }

    private fun convertComplexNumeralToInt(numString: String): Int {
        return 0
    }
}