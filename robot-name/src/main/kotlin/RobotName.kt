import kotlin.random.Random

class Robot {

    private var _name: String = ""
    val name: String
        get() = _name

    fun reset() {
        names.remove(_name)
        do {
            _name = ""
            repeat(2) { _name += randomChar() }
            repeat(3) { _name += Random.nextInt(9) }
        } while (names.contains(name))
        names.add(_name)
    }

    init {
        reset()
    }

    companion object {
        private val names = mutableSetOf<String>()

        fun randomChar() = Random.nextInt(65, 90).toChar()
    }
}