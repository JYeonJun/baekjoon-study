import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double creditSum = 0;
        double creditCnt = 0;

        Map<String, Double> subjects = new HashMap<>();
        subjects.put("A+", 4.5);
        subjects.put("A0", 4.0);
        subjects.put("B+", 3.5);
        subjects.put("B0", 3.0);
        subjects.put("C+", 2.5);
        subjects.put("C0", 2.0);
        subjects.put("D+", 1.5);
        subjects.put("D0", 1.0);
        subjects.put("F", 0.0);

        String[] line;
        double credit;
        String grade;
        for (int i = 0; i < 20; i++) {
            line = br.readLine().split(" ");
            credit = Double.parseDouble(line[1]);
            grade = line[2];

            if (grade.equals("P")) {
                continue;
            }

            creditSum += credit * subjects.getOrDefault(grade, 0.0);
            creditCnt += credit;
        }

        System.out.println(creditSum / creditCnt);
    }
}