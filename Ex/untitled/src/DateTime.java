import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.DAYS;

public class DateTime {
    private static LocalDate convertStringToLocalDate(String input) {
        return LocalDate.parse(input, DateTimeFormatter.BASIC_ISO_DATE);
    }

    private static long calculateDate(LocalDate startDate, LocalDate endDate) {
        return DAYS.between(startDate, endDate);
    }

    private static String convertLocalDateToString(LocalDate input) {
        return input.format(DateTimeFormatter.BASIC_ISO_DATE);
    }

    public static void totalDate(String start, String end) {
        System.out.println("start date ="+start+" end date =" +end);
        System.out.println( "count day : "+calculateDate(convertStringToLocalDate(start), convertStringToLocalDate(end))+" days");
    }

    public static void plusMonth(String start, int plus) {
        System.out.println("number of months plus : " + plus);
        System.out.println("End date : " +convertLocalDateToString(convertStringToLocalDate(start).plusMonths(plus)));
    }
}
