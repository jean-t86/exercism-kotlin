class CustomSet(vararg numbers: Int) {

    private val numbersList = numbers.toMutableList()

    init {
        numbers.sort()
    }

    fun isEmpty(): Boolean = numbersList.isEmpty()

    fun isSubset(other: CustomSet): Boolean =
        if (numbersList.isEmpty() && other.numbersList.isEmpty()) {
            true
        } else if (numbersList.isEmpty() && other.numbersList.isNotEmpty()) {
            true
        } else if (other.numbersList.isEmpty() && numbersList.isNotEmpty()) {
            false
        } else {
            other.numbersList.containsAll(numbersList)
        }

    fun isDisjoint(other: CustomSet): Boolean =
        !numbersList.any { other.numbersList.contains(it) }

    fun contains(other: Int): Boolean = numbersList.contains(other)

    fun intersection(other: CustomSet): CustomSet {
        val intersection = CustomSet()

        numbersList.forEach { num ->
            if (num == 3) {
                println()
            }
            if (other.contains(num)) {
                intersection.add(num)
            }
        }

        other.numbersList.forEach { otherNum ->
            if (otherNum == 3) {
                println()
            }
            if (contains(otherNum)) {
                intersection.add(otherNum)
            }
        }

        intersection.sort()
        return intersection
    }

    fun add(other: Int) {
        if (numbersList.isEmpty()) {
            numbersList.add(other)
        } else if (!contains(other)) {
            numbersList.add(other)
            numbersList.sort()
        }
    }

    private fun sort() = numbersList.sort()

    override fun equals(other: Any?): Boolean {
        if (other is CustomSet) {
            if (numbersList.size != other.numbersList.size) return false
            other.sort()
            numbersList.sort()
            numbersList.forEachIndexed { index, num ->
                if (other.numbersList[index] != num) {
                    return false
                }
            }
        } else {
            return false
        }

        return true
    }

    operator fun plus(other: CustomSet): CustomSet {
        val customSet = CustomSet()

        for (num in numbersList) {
            customSet.add(num)
        }

        for (otherNum in other.numbersList) {
            customSet.add(otherNum)
        }

        return CustomSet(*customSet.numbersList.toIntArray())
    }

    operator fun minus(other: CustomSet): CustomSet {
        numbersList.removeAll(other.numbersList)
        return CustomSet(*numbersList.toIntArray())
    }
}
