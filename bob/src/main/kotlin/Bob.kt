object Bob {
    fun hey(input: String): String {
        val trimmedInput = input.trim()

        return when {
            trimmedInput.isEmpty() -> "Fine. Be that way!"
            !isAQuestion(trimmedInput) && hasNoLetters(trimmedInput) -> "Whatever."
            !isAQuestion(trimmedInput) && isAllCaps(trimmedInput) -> "Whoa, chill out!"
            isAQuestion(trimmedInput) && !isAllCaps(trimmedInput) -> "Sure."
            isAQuestion(trimmedInput) && hasNoLetters(trimmedInput) -> "Sure."
            isAQuestion(trimmedInput) && isAllCaps(trimmedInput) -> "Calm down, I know what I'm doing!"
            else -> "Whatever."
        }
    }

    private fun isAllCaps(input: String): Boolean = input == input.toUpperCase()

    private fun isAQuestion(input: String): Boolean = input.lastOrNull() == '?'

    private fun hasNoLetters(input: String): Boolean = input
        .toUpperCase()
        .dropLast(1)
        .none { it in 'A'..'Z' }
}
