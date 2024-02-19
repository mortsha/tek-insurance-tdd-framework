package tek.tdd.utility;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateUtility {
    private final static DateTimeFormatter formattedTodayDate = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
    public static void main(String[] args) {

        DateUtility data = new DateUtility();
        System.out.println(data.todayDate());
        System.out.println(toLocalDate());

    }

    public String todayDate() {
        LocalDate date = toLocalDate();
        return date.format(formattedTodayDate);
    }
    public String incrementDate(int days){
        LocalDate date = toLocalDate().plusDays(days);
        return date.format(formattedTodayDate);
    }
    public static LocalDate toLocalDate(){
        return Instant.now().atZone(ZoneId.of("America/New_York")).toLocalDate();
    }
}
