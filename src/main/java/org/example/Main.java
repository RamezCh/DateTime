package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    }
}