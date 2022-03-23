object Series {

    fun slices(sliceLength: Int, inputStr: String): List<List<Int>> {
        val slices = mutableListOf<MutableList<Int>>()

        if (sliceLength > inputStr.length ||
            sliceLength <= 0 ||
            inputStr.isEmpty()
        ) {
            throw IllegalArgumentException()
        }

        for (index in inputStr.indices) {
            if (index + sliceLength <= inputStr.length) {
                val charSeries = inputStr.substring(index, index + sliceLength).toList()
                val intSeries = mutableListOf<Int>()
                for (char in charSeries) {
                    intSeries.add(char.toString().toInt())
                }
                slices.add(intSeries)
            }
        }

        return slices
    }
}
