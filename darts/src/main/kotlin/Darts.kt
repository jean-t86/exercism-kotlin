import kotlin.math.pow
import kotlin.math.sqrt

object Darts {

    fun score(x: Double, y: Double): Int {
        if (x == -3.6 && y == -3.6) {
            println()
        }
        val distanceFromCentre = distanceFromCentre(x, y)
        return when {
            distanceFromCentre > 10.0 -> 0
            distanceFromCentre in 5.01..10.0 -> 1
            distanceFromCentre in 1.01..5.01 -> 5
            distanceFromCentre in 0.0..1.01 -> 10
            else -> 10
        }
    }

    fun score(x: Int, y: Int): Int {
        return score(x.toDouble(), y.toDouble())
    }

    fun score(x: Double, y: Int): Int {
        return score(x, y.toDouble())
    }

    private fun distanceFromCentre(x: Double, y: Double): Double {
        val centreX = 0.0
        val centreY = 0.0
        val distanceX = (x - centreX).pow(2.0)
        val distanceY = (y - centreY).pow(2.0)
        return sqrt(distanceX + distanceY)
    }
}
