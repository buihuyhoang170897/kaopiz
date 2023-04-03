import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        System.out.println("Test 1");
        String startDate = "20170220";
        String closeDate = "20211224";
        DateTime.totalDate(startDate,closeDate);

        System.out.println("Test 2");
        startDate = "20170131";
        int numberOfMonthsPlus = 1;
        DateTime.plusMonth(startDate,numberOfMonthsPlus);    }
}
