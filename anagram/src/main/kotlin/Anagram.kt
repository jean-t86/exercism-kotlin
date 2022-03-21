class Anagram(private val source: String) {

    fun match(anagrams: Collection<String>): Set<String> {
        val validAnagrams: MutableSet<String> = mutableSetOf()

        for (anagram in anagrams) {
            val lowerCaseAnagram = anagram.toLowerCase()
            val lowerCaseSource = source.toLowerCase()

            lowerCaseAnagram.toList().sorted().let {
                val sourceSet = lowerCaseSource.toList().sorted()
                if (it == sourceSet && lowerCaseAnagram != lowerCaseSource) {
                    validAnagrams.add(anagram)
                }
            }
        }

        return validAnagrams
    }
}
