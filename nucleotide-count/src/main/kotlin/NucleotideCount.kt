class Dna(private val dnaStrand: String) {

    private val _nucleotideCounts: MutableMap<Char, Int> =
        mutableMapOf('A' to 0, 'C' to 0, 'G' to 0, 'T' to 0)

    init {
        if (dnaStrand.any { it !in listOf('A', 'C', 'G', 'T') }) {
            throw IllegalArgumentException()
        }
    }

    val nucleotideCounts: Map<Char, Int>
        get() {
            if (dnaStrand.isEmpty()) {
                return _nucleotideCounts
            }

            _nucleotideCounts.forEach { (key, value) ->
                _nucleotideCounts.set(key, dnaStrand.count { it == key })
            }

            return _nucleotideCounts
        }
}
