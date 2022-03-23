object Transpose {

    fun transpose(input: List<String>): List<String> {
        val result = mutableListOf<String>()

        for ((wordIndex, word) in input.withIndex()) {

            word.forEachIndexed { charIndex, char ->

                val currentChar = result.elementAtOrNull(charIndex)
                if (currentChar != null) {
                    val currentCharLength = currentChar.length
                    if (currentCharLength != wordIndex) {
                        // Add white space padding
                        result[charIndex] = "$currentChar $char"
                    } else {
                        result[charIndex] = currentChar + char.toString()
                    }
                } else {
                    result.add(" ".repeat(wordIndex) + char.toString())
                }

            }

        }

        return result
    }
}
