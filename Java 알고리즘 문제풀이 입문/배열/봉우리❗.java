import java.util.Scanner;

public class Main {
    public int solution(int n, int[][] grid) {
        int answer = 0;
        // 8방 같이 조건이 많은 경우 전부 조건문으로 구현하는 것은 비효율적임
        // 반복문을 돌리고, 조건에 부합하지 않으면 break 문을 호출하는 식으로 구현
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int num, i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                num = grid[i][j];

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    // indexOutOfBound 에러가 나지 않게 nx와 ny 범위 조건 지정
                    if ((nx >= 0 && nx < n) && (ny >= 0 && ny < n) && (num <= grid[nx][ny])) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
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
        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = in.nextInt();
            }
        }
        System.out.println(T.solution(n, grid));
    }
}
