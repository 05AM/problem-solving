import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Main {
    private static Map<String, Double> gradePoints = Map.of(
            "A+", 4.5,
            "A0", 4.0,
            "B+", 3.5,
            "B0", 3.0,
            "C+", 2.5,
            "C0", 2.0,
            "D+", 1.5,
            "D0", 1.0,
            "F", 0.0
    );
    private static final String PASS = "P";
    private static final int TRY_COUNT = 20;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        double totalCredit = 0;
        double currentSum = 0;
        for (int i = 0; i < TRY_COUNT; i++) {
            String[] input = in.readLine().split(" ");

            double credit = Double.parseDouble(input[1]);
            String grade = input[2];

            if (grade.equals(PASS)) {
                continue;
            }

            totalCredit += credit;
            currentSum += credit * gradePoints.get(grade);
        }

        double result = currentSum / totalCredit;

        System.out.println(result);
    }
}