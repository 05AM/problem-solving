import java.util.Scanner;

public class Main {
    public int[] solution(int n, int[] scores) {
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int score = scores[i];
            int rank = 1;

            // 나의 등수는 나보다 큰 원소가 몇 개 존재하는가에 달려있다.
            for (int j = 0; j < n; j++) {
                if (score < scores[j]) {
                    rank++;
                }
            }
            answer[i] = rank;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = in.nextInt();
        }

        for (int rank : T.solution(n, scores)) {
            System.out.print(rank + " ");
        }
    }
}
