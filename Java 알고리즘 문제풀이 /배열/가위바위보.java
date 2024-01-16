import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private String[] solution(int n, int[] optionsA, int[] optionsB) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            int a = optionsA[i];
            int b = optionsB[i];

            if (a == b) {
                // 비긴 경우
                answer[i] = "D";
            } else if ((a == 1 && b == 3) || (a == 2 && b == 1) || (a == 3 && b == 2)) {
                // 이긴 경우
                answer[i] = "A";
            } else {
                // 진 경우
                answer[i] = "B";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] optionsA = new int[n];
        int[] optionsB = new int[n];

        for (int i = 0; i < n; i++) {
            optionsA[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            optionsB[i] = in.nextInt();
        }

        Arrays.stream(T.solution(n, optionsA, optionsB))
                .forEach(System.out::println);
    }
}
