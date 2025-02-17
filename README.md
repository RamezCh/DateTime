# Java Date and Time Handling

## How can you increase or decrease a `LocalDate` by one day in Java?
You can increase or decrease a `LocalDate` by one day using the `plusDays(1)` or `minusDays(1)` methods:

```java
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        LocalDate yesterday = today.minusDays(1);

        System.out.println("Today: " + today);
        System.out.println("Tomorrow: " + tomorrow);
        System.out.println("Yesterday: " + yesterday);
    }
}
```

---

## You are building a birthday reminder app. It should remind you of possible birthdays of your friends at 10:00 in the morning. Which data type would be optimal for storing the birthdays of your friends?

The best data type for storing birthdays is `MonthDay`, which represents a date without a year. The time for reminders can be stored separately using `LocalTime`.

```java
import java.time.MonthDay;
import java.time.LocalTime;

MonthDay birthday = MonthDay.of(5, 20); // May 20th
LocalTime reminderTime = LocalTime.of(10, 0); // 10:00 AM
```

---

## You are building an online "Mensch Ärgere Dich Nicht" game. On the website, you can arrange games with friends from all over the world. In which data format would you store the timestamps of upcoming games?

For global events, `Instant` is the best format because it represents timestamps independent of time zones.

```java
import java.time.Instant;

Instant gameTime = Instant.now();
```

---

## In your banking software, you want to keep track of when a user has accepted the terms and conditions. How would you best store the timestamp of the click?

Since the timestamp should include date, time, and time zone, the best option is `ZonedDateTime`.

```java
import java.time.ZonedDateTime;
import java.time.ZoneId;

ZonedDateTime acceptedTime = ZonedDateTime.now(ZoneId.of("UTC"));
```

---

## Which data format would you choose in Java for these different pieces of information?

| Scenario | Data Type | Justification |
|----------|----------|--------------|
| The departure time of an airplane | `ZonedDateTime` | Different time zones are involved, so storing the exact departure time in a specific zone is necessary. |
| The times on a bus schedule | `LocalTime` | The bus schedule remains the same regardless of the date and time zone. |
| When the emergency call arrives at the central office | `Instant` | Precise global timestamp is required to avoid time zone issues. |
| When Easter takes place in the year 2022 | `LocalDate` | Easter is a date-based event without a specific time component. |
| How long a ticket with a 1-day validity lasts | `Duration` or `LocalDateTime` | The ticket's validity is measured in a duration (e.g., 24 hours), but you need a start date/time (LocalDateTime) to calculate the expiration. Alternatively, you can directly store the end date/time. |
| The date next to a signature (contract management software) | `LocalDate` | Only the date is needed, without time or zone details. |
| When New Year's Eve is (on January 1st at 00:00, regardless of location) | `LocalTime` or `LocalDateTime` | Time is fixed at 00:00 without consideration of time zones. |
| When the video call is | `ZonedDateTime` | The time of a video call varies depending on the participant's time zone. |

---

## Differences Between Java Date and Time Classes

| Class | Description |
|-------|-------------|
| `ZonedDateTime` | Represents a date-time with a time zone. Useful for storing events that are time-zone specific. |
| `LocalTime` | Represents only time (hours, minutes, seconds) without a date or time zone. Useful for recurring events like bus schedules. |
| `Instant` | Represents an absolute point in time, independent of time zones. Best for timestamps where global consistency is required. |
| `LocalDate` | Represents a date (year, month, day) without a time component or time zone. Useful for birthdays or holidays. |
| `Duration` | Represents a time span (e.g., "1 hour", "30 minutes"). Useful for measuring elapsed time. |
| `LocalDateTime` | Represents a date and time without a time zone. Best for timestamps where time zone handling is not required. |

---

## Comparing and Performing Common Time Operations

### Comparing Dates and Times

```java
import java.time.LocalDate;

LocalDate date1 = LocalDate.of(2022, 5, 20);
LocalDate date2 = LocalDate.of(2023, 5, 20);

boolean isBefore = date1.isBefore(date2);
boolean isAfter = date1.isAfter(date2);
boolean isEqual = date1.isEqual(date2);

System.out.println("Is date1 before date2? " + isBefore);
System.out.println("Is date1 after date2? " + isAfter);
System.out.println("Are both dates equal? " + isEqual);
```
---

### Adding and Subtracting Time

```java
import java.time.LocalDateTime;

LocalDateTime now = LocalDateTime.now();
LocalDateTime nextWeek = now.plusWeeks(1);
LocalDateTime lastMonth = now.minusMonths(1);

System.out.println("Now: " + now);
System.out.println("Next Week: " + nextWeek);
System.out.println("Last Month: " + lastMonth);
```
---

### Calculating Duration Between Two Dates

```java
import java.time.Duration;
import java.time.LocalTime;

LocalTime startTime = LocalTime.of(10, 0);
LocalTime endTime = LocalTime.of(12, 30);

Duration duration = Duration.between(startTime, endTime);
System.out.println("Duration in minutes: " + duration.toMinutes());
```
---

### Finding Difference Between Dates and Times

```java
import java.time.*;
import java.time.temporal.ChronoUnit;

public class DateDifferenceExample {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2020, 1, 1);
        LocalDate date2 = LocalDate.of(2023, 6, 15);

        long years = ChronoUnit.YEARS.between(date1, date2);
        long months = ChronoUnit.MONTHS.between(date1, date2);
        long weeks = ChronoUnit.WEEKS.between(date1, date2);
        long days = ChronoUnit.DAYS.between(date1, date2);

        System.out.println("Years: " + years);
        System.out.println("Months: " + months);
        System.out.println("Weeks: " + weeks);
        System.out.println("Days: " + days);
    }
}
```
---

### Finding Difference in Seconds and Nanoseconds

```java
import java.time.*;
import java.time.temporal.ChronoUnit;

public class TimeDifferenceExample {
    public static void main(String[] args) {
        Instant time1 = Instant.now();
        Instant time2 = time1.plusSeconds(5000);

        long seconds = ChronoUnit.SECONDS.between(time1, time2);
        long nanos = ChronoUnit.NANOS.between(time1, time2);

        System.out.println("Seconds Difference: " + seconds);
        System.out.println("Nanoseconds Difference: " + nanos);
    }
}
```
---

## Java ChronoUnit vs Duration

In Java, `ChronoUnit` and `Duration` are both used to work with time durations and measurements, but they serve different purposes. Below are the key differences between the two.

### ChronoUnit

`ChronoUnit` is an enum in the `java.time.temporal` package that represents standard units of time like seconds, minutes, hours, days, months, years, etc.

#### Key Features:
- Represents a unit of time like days, hours, minutes, seconds, etc.
- Works with `Temporal` objects like `LocalDate`, `LocalTime`, `LocalDateTime`, `ZonedDateTime`, etc.
- Common operations include `plus()`, `minus()`, `between()`, and `isSupportedBy()`.

#### Example:
```java
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ChronoUnitExample {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2025, 2, 17);
        LocalDate endDate = LocalDate.of(2025, 2, 20);
        
        // Calculate the number of days between two dates
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println("Days between: " + daysBetween);
    }
}
```
---

### Key Differences

|Feature	| ChronoUnit	| Duration |
|--------|------------|--------|
|Purpose |	Represents units of time (e.g., days, hours)	| Represents a fixed duration in seconds and nanoseconds |
|Time Measurement |	Works with larger time units (days, months, years)	| Works with time in seconds and nanoseconds |
|Common Methods |	between(), isSupportedBy(), plus(), minus()	| toSeconds(), toMillis(), toMinutes(), plus(), minus() |
|Usage |	Mainly used for working with date/time objects	| Mainly used for measuring or manipulating elapsed time between Instant objects |
|Supported Objects |	Temporal (LocalDate, LocalDateTime, etc.)	| Instant, LocalTime, Duration itself |


By using the appropriate date and time classes from `java.time`, you ensure correctness and clarity in your Java applications.
