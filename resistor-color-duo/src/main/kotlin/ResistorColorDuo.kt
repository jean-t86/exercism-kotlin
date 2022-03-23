object ResistorColorDuo {

    fun value(vararg colors: Color): Int {
        val strBuilder = StringBuilder()
        colors
            .take(2)
            .forEach {
                strBuilder.append(it.code)
            }
        return strBuilder.toString().toInt()
    }
}
