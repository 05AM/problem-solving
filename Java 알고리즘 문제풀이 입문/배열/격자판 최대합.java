import java.util.Scanner;

public class Main {
    public int solution(int n, int[][] grid) {
        // 굳이 모든 연산 결과를 저장할 필요없이 한 변수로 그때그때 판단 가능
        int answer = Integer.MIN_VALUE;
        int sum1, sum2, max;

        // 가로, 세로 합 구하고 비교하기
        for (int i = 0; i < n; i++) {
            sum1 = sum2 = 0;
            for (int j = 0; j < n; j++) {
                sum1 += grid[i][j];
                sum2 += grid[j][i];
            }
            max = Math.max(sum1, sum2);

            if (max > answer) {
                answer = max;
            }
        }

        // 두 대각선 합 구하기
        sum1 = sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += grid[i][i];
            sum2 += grid[i][n - i - 1];

            max = Math.max(sum1, sum2);

            if (i == n - 1) {
                if (max > answer) {
                    answer = max;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = in.nextInt();
            }
        }
        System.out.println(T.solution(n, grid));
    }
}
