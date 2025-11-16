import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test {
    public static void main(String[] args) {
        LocalDate test=LocalDate.of(2024, 12, 31);
        System.out.println(test.format(DateTimeFormatter.ofPattern("dd.MMM.yy")));
    }
}