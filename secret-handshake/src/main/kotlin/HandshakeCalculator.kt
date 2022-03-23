import java.math.BigInteger

const val REVERSE_ACTIONS = 10_000
const val UPPER_LIMIT = 100_000

object HandshakeCalculator {
    fun calculateHandshake(number: Int): List<Signal> {
        var binary = BigInteger.valueOf(number.toLong()).toString(2).toInt()
        val handshake = mutableListOf<Signal>()

        if (binary >= UPPER_LIMIT) return handshake

        var reverse = false
        if (binary - REVERSE_ACTIONS >= 0) {
            binary -= REVERSE_ACTIONS
            reverse = true
        }

        for (signal in Signal.values().sortedByDescending { it.value }) {
            if (binary >= signal.value) {
                binary -= signal.value
                if (binary >= 0) {
                    handshake.add(signal)
                }
            }
        }

        return if (reverse) handshake else handshake.reversed()
    }
}