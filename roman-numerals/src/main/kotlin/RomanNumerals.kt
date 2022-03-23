object RomanNumerals {

    private val romanNumeralsMap =
        mapOf(
            1 to "I",
            4 to "IV",
            5 to "V",
            9 to "IX",
            10 to "X",
            40 to "XL",
            50 to "L",
            90 to "XC",
            100 to "C",
            400 to "CD",
            500 to "D",
            900 to "CM",
            1000 to "M"
        )

    fun value(number: Int): String {
        if (romanNumeralsMap[number] != null) return romanNumeralsMap[number]!!

        var numToConvert = number
        var romanNumeral = ""

        val lowerNumbers = romanNumeralsMap.filter { it.key < number }
        lowerNumbers.keys.reversed().forEach { key ->
            if (key <= numToConvert) {
                while (numToConvert - key >= 0) {
                    numToConvert -= key
                    romanNumeral += romanNumeralsMap[key]
                }
            }
        }

        return romanNumeral
    }
}
