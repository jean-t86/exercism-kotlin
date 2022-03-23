object WordCount {

    fun phrase(phrase: String): Map<String, Int> {
        val contractions = "[a-z]+('[a-z]+)"
            .toRegex().findAll(phrase.lowercase())
            .map { it.groupValues[0] }
            .filter { it != "" }

        val simpleWords = "[a-z]*"
            .toRegex().findAll(phrase.lowercase().replace("[a-z]+('[a-z]+)".toRegex(), ""))
            .map { it.groupValues[0] }
            .filter { it != "" }

        val numbers = "[0-9]*"
            .toRegex().findAll(phrase.lowercase().replace("[a-z]+('[a-z]+)".toRegex(), ""))
            .map { it.groupValues[0] }
            .filter { it != "" }

        var words = (contractions + simpleWords + numbers).toMutableList()

        val occurrences = mutableMapOf<String, Int>()
        while (words.isNotEmpty()) {
            val word = words[0]
            val count = words.count { it == word }
            occurrences[word] = count
            words = words.filter { it != word }.toMutableList()
        }

        return occurrences
    }
}