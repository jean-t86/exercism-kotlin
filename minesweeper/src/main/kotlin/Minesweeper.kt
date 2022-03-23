class MinesweeperBoard(private val board: List<String>) {

    fun withNumbers(): List<String> {
        val mutableBoard = board.toMutableList()

        for (row in board.indices) {
            for (col in board[row].indices) {
                if (board[row][col] == '*') {
                    val top = row - 1
                    val bottom = row + 1
                    val left = col - 1
                    val right = col + 1

                    if (mutableBoard[row][col] == '*') {
                        val strLeftRight = mutableBoard[row].toMutableList()
                        if (left >= 0 && strLeftRight[left] != '*') {
                            incrementProximityMinesCount(strLeftRight, left)
                        }

                        if (right < strLeftRight.size && strLeftRight[right] != '*') {
                            incrementProximityMinesCount(strLeftRight, right)
                        }
                        mutableBoard[row] = strLeftRight.joinToString(separator = "")

                        if (top >= 0) {
                            val strTop = mutableBoard[top].toMutableList()
                            if (strTop[col] != '*') {
                                incrementProximityMinesCount(strTop, col)
                            }

                            if (left >= 0 && strTop[left] != '*') {
                                incrementProximityMinesCount(strTop, left)
                            }
                            if (right < strTop.size && strTop[right] != '*') {
                                incrementProximityMinesCount(strTop, right)
                            }
                            mutableBoard[top] = strTop.joinToString(separator = "")
                        }

                        if (bottom < mutableBoard.size) {
                            val strBottom = mutableBoard[bottom].toMutableList()
                            if (strBottom[col] != '*') {
                                incrementProximityMinesCount(strBottom, col)
                            }

                            if (left >= 0 && strBottom[left] != '*') {
                                incrementProximityMinesCount(strBottom, left)
                            }
                            if (right < strBottom.size && strBottom[right] != '*') {
                                incrementProximityMinesCount(strBottom, right)
                            }
                            mutableBoard[bottom] = strBottom.joinToString(separator = "")
                        }
                    }
                }
            }
        }

        return mutableBoard
    }
}

private fun incrementProximityMinesCount(str: MutableList<Char>, index: Int) {
    val temp = str[index].toString().toIntOrNull()
    if (temp != null) {
        str[index] = (temp + 1).toString().toCharArray()[0]
    } else {
        str[index] = '1'
    }
}
