import kotlin.math.pow

object ArmstrongNumber {

    fun check(number: Int): Boolean {
        val numList = number.toString().toList().reversed()
        val armstrongNumberValidation = numList.fold(0) { acc, char ->
            val num = char.toString().toDouble()
            acc + num.pow(numList.size).toInt()
        }

        return armstrongNumberValidation == number
    }

}
