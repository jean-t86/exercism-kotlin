object Isogram {

    private const val alphabet = "abcdefghijklmnopqrstuvwxyz"

    fun isIsogram(input: String): Boolean {
        val lettersOnly = input.toLowerCase().filter { alphabet.contains(it) }
        val lettersCount = lettersOnly.length
        val uniqueLettersCount = lettersOnly.toSet().size
        return lettersCount == uniqueLettersCount
    }
}