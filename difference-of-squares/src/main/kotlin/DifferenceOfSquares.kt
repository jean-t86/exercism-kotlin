import kotlin.math.pow

class Squares(private val upperLimit: Int) {

    fun sumOfSquares() : Int {
        var rollingSumOfSquares = 0
        for (i in 1..upperLimit) {
            rollingSumOfSquares += i.toDouble().pow(2).toInt()
        }
        return rollingSumOfSquares
    }

    fun squareOfSum() = (1..upperLimit).sum().toDouble().pow(2).toInt()

    fun difference() = squareOfSum() - sumOfSquares()
}
