object Raindrops {

    private val map = mapOf(3 to "Pling", 5 to "Plang", 7 to "Plong")

    fun convert(n: Int): String {
        val strBuilder: StringBuilder = StringBuilder()
        factors(n).let { factors ->
            // Convert 3, 5, and 7 to their respective words
            factors.forEach {
                if (map.containsKey(it)) {
                    strBuilder.append(map[it])
                }
            }

            // If strBuilder is still empty, n has neither of 3, 5, or 7 as factors
            if (strBuilder.isEmpty()) {
                strBuilder.append(n)
            }
        }
        return strBuilder.toString()
    }

    private fun factors(n: Int): List<Int> {
        val factors: MutableList<Int> = mutableListOf()
        for (i in 1..n) {
            if (n % i == 0) factors.add(i)
        }
        return factors
    }
}
