import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        String[] line = br.readLine().split(" ");
        int x = Integer.parseInt(line[0]);
        int y = Integer.parseInt(line[1]);

        LocalDate date = LocalDate.of(2007, x, y);
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        int dayNum = dayOfWeek.getValue();
        System.out.println(days[dayNum % 7]);
    }
}