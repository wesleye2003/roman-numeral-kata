fun main(args: Array<String>) {
    for (arg in args) {
        if (arg.toIntOrNull() != null) {
            val romanNumerals = NumberParser.parseRomanNumeralsFromInt(arg.toInt())
            println("${arg}'s Roman Numeral value is $romanNumerals")
        } else {
            val int = NumberParser.parseIntFromRomanNumerals(arg)
            println("${arg}'s integer value is $int")
        }
    }
}