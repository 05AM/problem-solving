import java.util.Scanner;

public class Main {

    static int n;
    static boolean isAnswerFound = false;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        solution(0);
    }

    private static void solution(int level) {
        if (isAnswerFound) {
            return;
        }

        if (level == n) {
            System.out.println(answer);
            isAnswerFound = true;
        } else {
            for (int j = 1; j <= 3; j++) {
                answer.append(j);
                if (!isBadSequence()) {
                    solution(level + 1);
                }
                answer.deleteCharAt(answer.length() - 1);
            }
        }
    }

    private static boolean isBadSequence() {
        int size = answer.length();
        boolean isBadSequence = false;

        for (int k = 1; size >= k * 2; k++) {
            if (isBadSequence) {
                break;
            }

            int i1 = size - k;
            int i2 = size - 2 * k;

            for (int i = 0; i < k; i++) {
                if (answer.charAt(i1 + i) != answer.charAt(i2 + i)) {
                    break;
                }

                if (i == k - 1) {
                    isBadSequence = true;
                }
            }
        }

        return isBadSequence;
    }
}