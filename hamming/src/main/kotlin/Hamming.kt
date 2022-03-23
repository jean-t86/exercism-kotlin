object Hamming {

    fun compute(leftStrand: String, rightStrand: String): Int {
        // Hamming distance is only valid for DNA strands of the same length
        if (leftStrand.length != rightStrand.length) {
            throw IllegalArgumentException("left and right strands must be of equal length")
        }

        return leftStrand.foldIndexed(0) { index, acc, letter ->
            if (letter != rightStrand[index]) {
                acc + 1
            } else {
                acc
            }
        }
    }
}
