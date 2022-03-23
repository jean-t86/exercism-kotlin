class Matrix(private val matrixAsString: String) {

    private val matrix: MutableList<List<Int>> = mutableListOf()

    init {
        matrixAsString
            .split("\n")
            .forEach { str ->
                val row = str.split(" ")
                    .filter { it != "" }
                    .map(String::toInt)
                matrix.add(row)
            }
    }

    fun column(colNr: Int): List<Int> {
        val index = colNr - 1
        val columnValues = mutableListOf<Int>()
        for (i in 0..matrix.lastIndex) {
            columnValues.add(matrix[i][index])
        }
        return columnValues
    }

    fun row(rowNr: Int): List<Int> = matrix[rowNr - 1]
}
