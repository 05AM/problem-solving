import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(new InputStreamReader(System.in));
        final int INF = 9999999;

        int n = in.nextInt();   // 지역 개수
        int m = in.nextInt();   // 수색 범위
        int r = in.nextInt();   // 길의 개수

        int[] items = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            items[i] = in.nextInt();
        }

        // 초기화
        int[][] distances = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(distances[i], INF);
            distances[i][i] = 0;
        }

        for (int i = 1; i <= r; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int l = in.nextInt();

            distances[a][b] = Math.min(distances[a][b], l);
            distances[b][a] = Math.min(distances[b][a], l);
        }

        System.out.println(solution(n, m, items, distances));
    }

    private static int solution(int n, int m, int[] items, int[][] distances) {
        for (int k = 1; k <= n; k++) {
            for (int row = 1; row <= n; row++) {
                for (int col = 1; col <= n; col++) {
                    distances[row][col] = Math.min(distances[row][col], distances[row][k] + distances[k][col]);
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int from = 1; from <= n; from++) {
            int itemCnt = 0;

            for (int to = 1; to <= n; to++) {
                if (distances[from][to] <= m) {
                    itemCnt += items[to];
                }
            }
            answer = Math.max(answer, itemCnt);
        }

        return answer;
    }
}
