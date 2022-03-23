import kotlin.math.floor
import kotlin.random.Random
import kotlin.random.nextInt

class DndCharacter {
    val strength: Int = ability()
    val dexterity: Int = ability()
    val constitution: Int = ability()
    val intelligence: Int = ability()
    val wisdom: Int = ability()
    val charisma: Int = ability()

    val hitPoints: Int = INITIAL_HIT_POINTS + modifier(constitution)

    companion object {
        private const val INITIAL_HIT_POINTS = 10

        fun ability(): Int = StatGenerator.randomStat()

        fun modifier(constitution: Int): Int {
            return floor((constitution - INITIAL_HIT_POINTS) / 2.0).toInt()
        }
    }
}

object StatGenerator {
    private const val DICE_MIN_VALUE = 1
    private const val DICE_MAX_VALUE = 6
    private const val DICES_THROWN = 4

    private fun roll(): Int = Random.nextInt(DICE_MIN_VALUE..DICE_MAX_VALUE)

    fun randomStat(): Int {
        val rolls: MutableList<Int> = mutableListOf()
        repeat(DICES_THROWN) { rolls.add(roll()) }
        return rolls
            .sum()
            .minus(rolls.minOrNull() ?: DICE_MIN_VALUE)
    }
}
