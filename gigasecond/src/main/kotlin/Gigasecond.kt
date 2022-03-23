import java.time.LocalDate
import java.time.LocalDateTime
import kotlin.math.pow

class Gigasecond(localDateTime: LocalDateTime) {

    constructor(localDate: LocalDate) : this(localDate.atStartOfDay())

    val date: LocalDateTime = localDateTime.plusSeconds(GIGASECOND)

    companion object {
        private val GIGASECOND: Long = 10.0.pow(9.0).toLong()
    }
}
