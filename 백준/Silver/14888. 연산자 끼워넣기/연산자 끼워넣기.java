import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static int[] operators;
    static int[] operands;

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());

        operands = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        operators = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        solution(1, operands[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void solution(int level, int sum) {
        if (level == n) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] == 0) {
                continue;
            }

            operators[i]--;

            switch (i) {
                case 0:
                    solution(level + 1, sum + operands[level]);
                    operators[i]++;
                    break;
                case 1:
                    solution(level + 1, sum - operands[level]);
                    operators[i]++;
                    break;
                case 2:
                    solution(level + 1, sum * operands[level]);
                    operators[i]++;
                    break;
                case 3:
                    solution(level + 1, sum / operands[level]);
                    operators[i]++;
                    break;
            }
        }
    }
}