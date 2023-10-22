object NumberParser {
    // Page I referenced for the "rules" of Roman Numerals:
    // https://www.toppr.com/guides/maths/knowing-our-numbers/roman-numerals/
    private const val numeralOne = "I"
    private const val numeralFive = "V"
    private const val numeralTen = "X"
    private const val numeralFifty = "L"
    private const val numeralOneHundred = "C"
    private const val numeralFiveHundred = "D"
    private const val numeralOneThousand = "M"
    fun parseIntFromRomanNumerals(numString: String): Int {
        val uppercaseNumString = numString.uppercase()
        // convert simple numerals immediately
        if (uppercaseNumString.length == 1) {
            return convertSimpleNumeralToInt(uppercaseNumString)
        }

        val numeralList = uppercaseNumString.map{it.toString()}.withIndex()
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

    private fun isSimpleNumeral(
        numeral: IndexedValue<String>,
        numeralList: Iterable<IndexedValue<String>>
    ): Boolean {
        val integerNumeralValue = convertSimpleNumeralToInt(numeral.value)

        return if ((numeral == numeralList.first()) && (numeral == numeralList.last())) {
            true
        } else if (
            (numeralList.elementAtOrNull(numeral.index+1) != null) &&
            (numeralList.elementAtOrNull(numeral.index-1) != null)
        ) {
            val nextNumeralIntegerValue = convertSimpleNumeralToInt(numeralList.elementAt(numeral.index+1).value)
            val prevNumeralIntegerValue = convertSimpleNumeralToInt(numeralList.elementAt(numeral.index-1).value)
            (integerNumeralValue in nextNumeralIntegerValue..prevNumeralIntegerValue)
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

    private fun validateNumeralFormat(
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
        if (
            isFirstPartOfComplexNumeral(numeral, numeralList)
        ) {
            if (
                numeral.value == numeralOne && (
                        numeralList.elementAt(numeral.index + 1).value != (numeralOne) &&
                                numeralList.elementAt(numeral.index + 1).value != (numeralFive) &&
                                numeralList.elementAt(numeral.index + 1).value != (numeralTen)
                        )
            ) {
                throw Error("Invalid Number String")
            } else if (
                numeral.value == numeralTen && (
                        numeralList.elementAt(numeral.index + 1).value != (numeralTen) &&
                                numeralList.elementAt(numeral.index + 1).value != (numeralFifty) &&
                                numeralList.elementAt(numeral.index + 1).value != (numeralOneHundred) &&
                                numeralList.elementAt(numeral.index + 1).value != (numeralOneThousand)
                        )
            ) {
                throw Error("Invalid Number String")
            }
        }
    }

    private fun isFirstPartOfComplexNumeral(
        numeral: IndexedValue<String>,
        numeralList: Iterable<IndexedValue<String>>
    ): Boolean {
        val integerNumeralValue = convertSimpleNumeralToInt(numeral.value)

        return if (numeralList.elementAtOrNull(numeral.index+1) != null) {
            val nextNumeralIntegerValue = convertSimpleNumeralToInt(numeralList.elementAt(numeral.index+1).value)
            (integerNumeralValue <= nextNumeralIntegerValue)
        } else {
            false
        }
    }
}