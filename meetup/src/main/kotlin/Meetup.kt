import java.time.DayOfWeek
import java.time.LocalDate

class Meetup(private val month: Int, private val year: Int) {

    fun day(dayOfWeek: DayOfWeek, schedule: MeetupSchedule): LocalDate {
        val firstDayOfMonth = LocalDate.of(year, month, 1)
        val lastDayOfMonth = LocalDate.of(year, month, firstDayOfMonth.lengthOfMonth())

        return when (schedule) {
            MeetupSchedule.FIRST -> {
                val firstWeek = firstDayOfMonth.datesUntil(lastDayOfMonth).filter { date ->
                    date.dayOfWeek == dayOfWeek
                }.toArray()
                firstWeek[0] as LocalDate
            }
            MeetupSchedule.SECOND -> {
                val secondWeek = firstDayOfMonth
                    .plusDays(7)
                    .datesUntil(lastDayOfMonth).filter { date ->
                        date.dayOfWeek == dayOfWeek
                    }.toArray()
                secondWeek[0] as LocalDate
            }
            MeetupSchedule.THIRD -> {
                val thirdWeek = firstDayOfMonth
                    .plusDays(14)
                    .datesUntil(lastDayOfMonth).filter { date ->
                        date.dayOfWeek == dayOfWeek
                    }.toArray()
                thirdWeek[0] as LocalDate
            }
            MeetupSchedule.FOURTH -> {
                val fourthWeek = firstDayOfMonth
                    .plusDays(21)
                    .datesUntil(lastDayOfMonth).filter { date ->
                        date.dayOfWeek == dayOfWeek
                    }.toArray()
                fourthWeek[0] as LocalDate
            }
            MeetupSchedule.LAST -> {
                val firstDayOfFollowingMonth = lastDayOfMonth.plusDays(1)
                val allDaysOfRequestedWeek = firstDayOfMonth.datesUntil(firstDayOfFollowingMonth).filter { date ->
                    date.dayOfWeek == dayOfWeek
                }.toArray()
                allDaysOfRequestedWeek.takeLast(1)[0] as LocalDate
            }
            MeetupSchedule.TEENTH -> {
                val teenthDate = firstDayOfMonth.datesUntil(lastDayOfMonth).filter { date ->
                    isTeenth(dayOfWeek, date)
                }.toArray()
                teenthDate[0] as LocalDate
            }
        }
    }

    private fun isTeenth(dayOfWeek: DayOfWeek, date: LocalDate): Boolean =
        date.dayOfMonth in teenth && date.dayOfWeek == dayOfWeek

    private val teenth: List<Int> = listOf(13, 14, 15, 16, 17, 18, 19)
}
