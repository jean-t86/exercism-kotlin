object Flattener {
    fun flatten(source: Collection<Any?>): List<Any> {
        return source.filterNotNull().flatMap {
            if (it is List<*>) flatten(it) else listOf(it)
        }
    }
}
