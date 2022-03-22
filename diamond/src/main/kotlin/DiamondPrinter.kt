class DiamondPrinter {

    private val asciiOfA = 65

    fun printToList(letter: Char): List<String> {
        val diamond: MutableList<String> = mutableListOf()

        val asciiOfLetter = letter.code
        for (i in asciiOfA..asciiOfLetter) {
            val diamondRow: String = when (i) {
                asciiOfA -> {
                    val trailPadding: String = " ".repeat(asciiOfLetter - i)
                    "$trailPadding${i.toChar()}$trailPadding"
                }
                asciiOfLetter -> {
                    val midPadding: String = " ".repeat(diamond.size * 2 - 1)
                    "${i.toChar()}$midPadding${i.toChar()}"
                }
                else -> {
                    val trailPadding: String = " ".repeat(asciiOfLetter - i)
                    val midPadding: String = " ".repeat(diamond.size * 2 - 1)
                    "$trailPadding${i.toChar()}$midPadding${i.toChar()}$trailPadding"
                }
            }

            diamond.add(diamondRow)
        }

        val diamondLowerHalf = diamond.dropLast(1).reversed()
        diamond.addAll(diamondLowerHalf)
        return diamond
    }
}
