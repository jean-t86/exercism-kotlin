object Acronym {
    fun generate(phrase: String): String {
        val cleanedUpPhrase = phrase
            .replace('-', ' ')
            .replace('_', ' ')

        val words = cleanedUpPhrase.split(" ")
        return if (words.isNotEmpty()) {
            words.fold("") { acc, str ->
                if (str.isEmpty()) {
                    acc
                } else {
                    acc + str.first()
                }
            }
        } else {
            ""
        }.toUpperCase()
    }
}
