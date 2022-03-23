class RotationalCipher(private val key: Int) {

    fun encode(text: String): String {
        return text.map {
            if (it.isLowerCase()) {
                if (it !in 'a'..'z' ) {
                    return@map it
                } else {
                    var asciiCode = it.code + key
                    if (asciiCode > 'z'.code) asciiCode -= MAX_ROTATION_KEY
                    asciiCode.toChar()
                }
            } else {
                if (it !in 'A'..'Z') {
                    return@map it
                } else {
                    var asciiCode = it.code + key
                    if (asciiCode > 'Z'.code) asciiCode -= MAX_ROTATION_KEY
                    asciiCode.toChar()
                }
            }
        }.joinToString("")
    }

    companion object {
        const val MAX_ROTATION_KEY = 26
    }

}
