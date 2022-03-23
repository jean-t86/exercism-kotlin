import java.time.LocalDate

data class Year(val year: Int) {
    val isLeap: Boolean = LocalDate.of(year, 1, 1).isLeapYear
}
