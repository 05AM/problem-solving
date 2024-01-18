import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public int[] solution(int n, Integer[] scores) {
        int[] answer = new int[n];
        Integer[] scoresOrdered = Arrays.copyOf(scores, n);
        Arrays.sort(scoresOrdered, Comparator.reverseOrder());

        for (int i = 0, rank = 1; i < n; i++) {
            int score = scoresOrdered[i];
            int nextRank = rank;

            for (int j = 0; j < n; j++) {
                if (answer[j] == 0) {
                    if (scores[j] == score) {
                        answer[j] = rank;
                        nextRank++;
                    }
                }
            }
            rank = nextRank;
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        Integer[] scores = new Integer[n];

        for (int i = 0; i < n; i++) {
            scores[i] = in.nextInt();
        }

        for (int rank : T.solution(n, scores)) {
            System.out.print(rank + " ");
        }
    }
}
