import java.util.Scanner;

public class Main {
    public int solution(int[] scorecard) {
        int answer = 0;
        int point = 1;

        for (int correctness : scorecard) {
            if (correctness == 0) {
                point = 1;
            } else {
                answer += point++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] scorecard = new int[n];

        for (int i = 0; i < n; i++) {
            scorecard[i] = in.nextInt();
        }
        System.out.print(T.solution(scorecard));
    }
}
