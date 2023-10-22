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
        for (numeral in numeralList) {
            validateNumeralFormat(numeral, numeralList)
            if (isSimpleNumeral(numeral, numeralList)) {
                finalNumber += convertSimpleNumeralToInt(numeral.value)
            } else if (isFirstPartOfComplexNumeral(numeral, numeralList)) {
                val nextNumeral = numeralList.elementAt(numeral.index+1).value
                val complexNumeral = numeral.value + nextNumeral
                finalNumber += convertComplexNumeralToInt(complexNumeral)
            }
        }
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
        val firstNumeralIntegerValue = convertSimpleNumeralToInt(numString.map{it.toString()}[0])
        val secondNumeralIntegerValue = convertSimpleNumeralToInt(numString.map{it.toString()}[1])

        return secondNumeralIntegerValue - firstNumeralIntegerValue
    }

    fun isSimpleNumeral(
        numeral: IndexedValue<String>,
        numeralList: Iterable<IndexedValue<String>>
    ): Boolean {
        val integerNumeralValue = convertSimpleNumeralToInt(numeral.value)

        return if ((numeral == numeralList.first()) && (numeral == numeralList.last())) {
            true
        } else if (numeralList.elementAtOrNull(numeral.index+1) != null) {
            val nextNumeralIntegerValue = convertSimpleNumeralToInt(numeralList.elementAt(numeral.index+1).value)
            (integerNumeralValue >= nextNumeralIntegerValue)
        } else if (numeralList.elementAtOrNull(numeral.index-1) != null) {
            val prevNumeralIntegerValue = convertSimpleNumeralToInt(numeralList.elementAt(numeral.index-1).value)
            (integerNumeralValue <= prevNumeralIntegerValue)
        } else {
            false
        }
    }

    fun validateNumeralFormat(
        numeral: IndexedValue<String>,
        numeralList: Iterable<IndexedValue<String>>
    ) {
        if (isFirstPartOfComplexNumeral(numeral, numeralList)) {
            when (numeral.value) {
                numeralFive -> throw Error("Invalid Number String")
                numeralFifty -> throw Error("Invalid Number String")
                numeralFiveHundred -> throw Error("Invalid Number String")
            }
        }
    }

    fun isFirstPartOfComplexNumeral(
        numeral: IndexedValue<String>,
        numeralList: Iterable<IndexedValue<String>>
    ): Boolean {
        val integerNumeralValue = convertSimpleNumeralToInt(numeral.value)

        return if (numeralList.elementAtOrNull(numeral.index+1) != null) {
            val nextNumeralIntegerValue = convertSimpleNumeralToInt(numeralList.elementAt(numeral.index+1).value)
            (integerNumeralValue < nextNumeralIntegerValue)
        } else {
            false
        }
    }
}