data class MatrixCoordinate(val row: Int, val col: Int)

class Matrix(private val matrix: List<List<Int>>) {
    private val rows: Int = matrix.size
    private val cols: Int? = matrix.getOrNull(0)?.size

    private val _saddlePoints: MutableSet<MatrixCoordinate> = mutableSetOf()
    val saddlePoints: Set<MatrixCoordinate>
        get() = _saddlePoints.toSet()

    init {
        for (i in 0 until rows) {
            for (j in 0 until cols!!) {
                val saddlePoint = MatrixCoordinate(i + 1, j + 1)
                if (isRowSaddle(saddlePoint) && isColSaddle(saddlePoint)) _saddlePoints.add(saddlePoint)
            }
        }
    }

    private fun isRowSaddle(coordinate: MatrixCoordinate): Boolean {
        val row = coordinate.row - 1
        val col = coordinate.col - 1
        for (i in 0 until cols!!) {
            if (matrix[row][col] < matrix[row][i]) return false
        }

        return true
    }

    private fun isColSaddle(coordinate: MatrixCoordinate): Boolean {
        val row = coordinate.row - 1
        val col = coordinate.col - 1
        for (i in 0 until rows) {
            if (matrix[row][col] > matrix[i][col]) return false
        }

        return true
    }
}