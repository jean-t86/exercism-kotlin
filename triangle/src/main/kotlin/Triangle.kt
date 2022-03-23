class Triangle<out T : Number>(private val a: T, private val b: T, private val c: T) {

    init {
        if (a == 0 || b == 0 || c == 0) {
            throw IllegalArgumentException()
        }

        if (a.toDouble() + b.toDouble() < c.toDouble() ||
                a.toDouble() + c.toDouble() < b.toDouble() ||
                b.toDouble() + c.toDouble() < a.toDouble()) {
            throw IllegalArgumentException()
        }
    }

    val isEquilateral: Boolean
        get() = a == b && b == c

    val isIsosceles: Boolean
        get() = a == b || a == c || b == c

    val isScalene: Boolean
        get() = a != b && b != c && a != c
}