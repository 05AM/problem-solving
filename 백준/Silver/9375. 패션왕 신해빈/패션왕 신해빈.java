import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int testCases = in.nextInt();
        for (int i = 0; i < testCases; i++) {
            int cnt = in.nextInt();

            Map<String, Integer> clothes = new HashMap<>();
            for (int j = 0; j < cnt; j++) {
                String name = in.next();
                String type = in.next();
                clothes.merge(type, 1, Integer::sum);
            }

            int cases = clothes.values().stream()
                    .mapToInt(v -> v + 1)
                    .reduce(1, (a, b) -> a * b);

            System.out.println(cases - 1);
        }

        in.close();
    }
}