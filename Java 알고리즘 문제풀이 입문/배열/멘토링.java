import java.util.Scanner;

public class Main {
    public int solution(int n, int m, int[][] ranks) {
        int answer = 0;

        // 학생 각각을 비교한다.
        for (int s1 = 1; s1 <= n; s1++) {
            for (int s2 = 1; s2 <= n; s2++) {
                // 같으면 넘긴다.
                if (s1 == s2) {
                    continue;
                }
                boolean isHigher = true;
                // 각 시험 결과를 비교한다.
                for (int row = 0; row < m; row++) {
                    int s1Rank = -1;
                    int s2Rank = -1;

                    // 각 시험 결과에서 두 학생의 등수를 구한다.
                    for (int k = 0; k < n; k++) {
                        if (ranks[row][k] == s1) {
                            s1Rank = k;
                        } else if (ranks[row][k] == s2) {
                            s2Rank = k;
                        }
                        if (s1Rank != -1 && s2Rank != -1) {
                            break;
                        }
                    }

                    // 비교학생의 등수가 한번이라도 높으면 break
                    if (s1Rank < s2Rank) {
                        isHigher = false;
                        break;
                    }
                }
                if (isHigher) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[][] ranks = new int[m][n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                ranks[row][col] = in.nextInt();
            }
        }
        System.out.println(T.solution(n, m, ranks));
    }
}
