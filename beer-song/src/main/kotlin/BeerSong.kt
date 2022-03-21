object BeerSong {
    fun verses(startBottles: Int, takeDown: Int): String {
        val strBuilder: StringBuilder = StringBuilder()
        var currentBottlesCount = startBottles

        for (i in startBottles downTo takeDown) {
            if (currentBottlesCount == 0) {
                strBuilder.append(
                    """
                    No more bottles of beer on the wall, no more bottles of beer.
                    Go to the store and buy some more, 99 bottles of beer on the wall.
                    
                """.trimIndent()
                )
            } else if (currentBottlesCount == 1) {
                strBuilder.append(
                    """
                    $currentBottlesCount bottle of beer on the wall, $currentBottlesCount bottle of beer.
                    Take it down and pass it around, no more bottles of beer on the wall.
                    
                """.trimIndent()
                )
            } else if (currentBottlesCount == 2) {
                strBuilder.append(
                    """
                    $currentBottlesCount bottles of beer on the wall, $currentBottlesCount bottles of beer.
                    Take one down and pass it around, ${currentBottlesCount - 1} bottle of beer on the wall.
                    
                """.trimIndent()
                )
            } else {
                strBuilder.append(
                    """
                    $currentBottlesCount bottles of beer on the wall, $currentBottlesCount bottles of beer.
                    Take one down and pass it around, ${currentBottlesCount - 1} bottles of beer on the wall.
                    
                """.trimIndent()
                )
            }

            if (currentBottlesCount != takeDown) {
                strBuilder.appendln()
            }

            currentBottlesCount--
        }
        return strBuilder.toString()
    }
}
