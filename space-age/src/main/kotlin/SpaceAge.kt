import java.math.RoundingMode
import java.text.DecimalFormat

class SpaceAge(private val ageInSeconds: Long) {

    fun onEarth(): Double = roundToTwoDecimalPlaces(ageOnEarthNotRounded())

    fun onMercury(): Double = roundToTwoDecimalPlaces(ageOnEarthNotRounded() / MERCURY_TO_EARTH_DIVISOR)

    fun onVenus(): Double = roundToTwoDecimalPlaces(ageOnEarthNotRounded() / VENUS_TO_EARTH_DIVISOR)

    fun onMars(): Double = roundToTwoDecimalPlaces(ageOnEarthNotRounded() / MARS_TO_EARTH_DIVISOR)

    fun onJupiter(): Double = roundToTwoDecimalPlaces(ageOnEarthNotRounded() / JUPITER_TO_EARTH_DIVISOR)

    fun onSaturn(): Double = roundToTwoDecimalPlaces(ageOnEarthNotRounded() / SATURN_TO_EARTH_DIVISOR)

    fun onUranus(): Double = roundToTwoDecimalPlaces(ageOnEarthNotRounded() / URANUS_TO_EARTH_DIVISOR)

    fun onNeptune(): Double = roundToTwoDecimalPlaces(ageOnEarthNotRounded() / NEPTUNE_TO_EARTH_DIVISOR)

    private fun ageOnEarthNotRounded(): Double = ageInSeconds / 60.0 / 60.0 / 24.0 / 365.25

    private fun roundToTwoDecimalPlaces(num: Double): Double {
        val decimalFormat = DecimalFormat("#.##")
        decimalFormat.roundingMode = RoundingMode.HALF_UP

        return decimalFormat.format(num).toDouble()
    }

    companion object {
        const val MERCURY_TO_EARTH_DIVISOR = 0.2408467
        const val VENUS_TO_EARTH_DIVISOR = 0.61519726
        const val MARS_TO_EARTH_DIVISOR = 1.8808158
        const val JUPITER_TO_EARTH_DIVISOR = 11.862615
        const val SATURN_TO_EARTH_DIVISOR = 29.447498
        const val URANUS_TO_EARTH_DIVISOR = 84.016846
        const val NEPTUNE_TO_EARTH_DIVISOR = 164.79132

    }
}
