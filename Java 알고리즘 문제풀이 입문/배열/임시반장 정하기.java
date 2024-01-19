import java.util.Scanner;

public class Main {
    public int solution(int n, int[][] grid) {
        int max = Integer.MIN_VALUE;
        int answer = -1;
        int cnt;

        // 몇 명의 학생과 같은 반이였는가?
        // 아이디어: 한 학생과 다른 모든 학생들의 반을 순서대로 대조해가며 같은 반을 했던 명 수를 구한다.
        // 중복이 되면 안되므로 break 문을 사용한다.
        for (int i = 0; i < n; i++) {
            cnt = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 5; k++) {
                    if (i == j) {
                        break;
                    }
                    if (grid[i][k] == grid[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if (cnt > max) {
                answer = i;
                max = cnt;
            }
        }
        return answer + 1;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] grid = new int[n][5];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                grid[i][j] = in.nextInt();
            }
        }
        System.out.println(T.solution(n, grid));
    }
}
