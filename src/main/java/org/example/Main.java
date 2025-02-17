package org.example;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        // Step 1: Output the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current Date and Time: " + currentDateTime);

        // Step 2: Add a timespan of 2 weeks to the current date and output the new date
        LocalDate currentDate = LocalDate.now();
        LocalDate dateInTwoWeeks = currentDate.plusWeeks(2);
        System.out.println("Date in 2 Weeks: " + dateInTwoWeeks);

        // Step 3: Compare the current date with a specified future date
        LocalDate futureDate = LocalDate.of(2024, 12, 25);
        if (currentDate.isBefore(futureDate)) {
            System.out.println("Current date is BEFORE the specified future date: " + futureDate);
        } else if (currentDate.isAfter(futureDate)) {
            System.out.println("Current date is AFTER the specified future date: " + futureDate);
        } else {
            System.out.println("Current date is EQUAL to the specified future date: " + futureDate);
        }

        // Step 4: Calculate the difference in days between two arbitrary dates
        LocalDate date1 = LocalDate.of(2023, 10, 1);
        LocalDate date2 = LocalDate.of(2025, 10, 1);
        long daysBetween = ChronoUnit.DAYS.between(date1, date2);
        System.out.println("Difference in days between " + date1 + " and " + date2 + ": " + daysBetween + " days");

        // Play around, test things out
        System.out.println("--- Play Field ---");
        // Year, Month, Day
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        LocalDate yesterday = today.minusDays(1);

        System.out.println("Today: " + today);
        System.out.println("Tomorrow: " + tomorrow);
        System.out.println("Yesterday: " + yesterday);

        // Year, Month, Day, Separator, Hour:Minute:Second.ZoneID
        Instant gameTime = Instant.now();
        System.out.println(gameTime);

        ZonedDateTime acceptedTime = ZonedDateTime.now(ZoneId.of("UTC"));
        System.out.println(acceptedTime);

        LocalDate date3 = LocalDate.of(2022, 5, 20);
        LocalDate date4 = LocalDate.of(2023, 5, 20);

        boolean isBefore = date3.isBefore(date4);
        boolean isAfter = date3.isAfter(date4);
        boolean isEqual = date3.isEqual(date4);

        System.out.println("Is date3 before date4? " + isBefore);
        System.out.println("Is date3 after date4? " + isAfter);
        System.out.println("Are both dates equal? " + isEqual);

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextWeek = now.plusWeeks(1);
        LocalDateTime lastMonth = now.minusMonths(1);

        System.out.println("Now: " + now);
        System.out.println("Next Week: " + nextWeek);
        System.out.println("Last Month: " + lastMonth);

        LocalTime startTime = LocalTime.of(10, 0);
        LocalTime endTime = LocalTime.of(12, 30);

        Duration duration = Duration.between(startTime, endTime);
        System.out.println("Duration in minutes: " + duration.toMinutes());

        LocalDate date5 = LocalDate.of(2020, 1, 1);
        LocalDate date6 = LocalDate.of(2023, 6, 15);

        long years = ChronoUnit.YEARS.between(date5, date6);
        long months = ChronoUnit.MONTHS.between(date5, date6);
        long weeks = ChronoUnit.WEEKS.between(date5, date6);
        long days = ChronoUnit.DAYS.between(date5, date6);

        System.out.println("Years: " + years);
        System.out.println("Months: " + months);
        System.out.println("Weeks: " + weeks);
        System.out.println("Days: " + days);

        Instant time1 = Instant.now();
        Instant time2 = time1.plusSeconds(5000);

        long seconds = ChronoUnit.SECONDS.between(time1, time2);
        long nanos = ChronoUnit.NANOS.between(time1, time2);

        System.out.println("Seconds Difference: " + seconds);
        System.out.println("Nanoseconds Difference: " + nanos);


    }
}