class IsbnVerifier {

    fun isValid(number: String): Boolean {
        if (number.isEmpty()) return false
        val sanitizedNumber = number.replace("-", "")
        if (sanitizedNumber.length != 10) return false

        val numberList = sanitizedNumber
            .split("")
            .drop(1)
            .dropLast(1)
            .toMutableList()

        if (numberList.last() == "X") numberList[numberList.lastIndex] = "10"
        if (containsAlphabeticCharacters(numberList)) return false

        var multiplier = 11
        val checkSum = numberList.fold(0) {acc: Int, str: String ->
            multiplier--
            str.toInt() * multiplier + acc
        }

        return checkSum % 11 == 0
    }

    private fun containsAlphabeticCharacters(numberList: List<String>): Boolean =
        numberList.any {
            it in "A".."z"
        }

}
