import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int min = Integer.MAX_VALUE;

    private static boolean[][] ladders;
    private static int n, m, h;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        ladders = new boolean[h + 1][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ladders[a][b] = true;
        }

        solution(0, 1, 1);
        min = min == Integer.MAX_VALUE ? -1 : min;
        System.out.println(min);
    }

    private static void solution(int level, int startRow, int startCol) {
        if (level > 3) {
            return;
        }

        // 현재 상태에서 사다리를 탔을 때 다 자신의 번호로 가는지 확인
        if (check()) {
            min = Math.min(min, level);
            return;
        }

        for (int r = startRow; r <= h; r++) {
            for (int c = (r == startRow ? startCol : 1); c < n; c++) {
                if (ladders[r][c]) {
                    continue;
                }

                if (isAvailable(r, c)) {
                    ladders[r][c] = true;
                    solution(level + 1, r, c + 2);
                    ladders[r][c] = false;
                }
            }
        }
    }

    private static boolean isAvailable(int r, int c) {
        int nextR = r;
        int nextC = c - 1;

        // 현재 위치에서 좌우에 존재하는지
        if (inRange(nextR, nextC) && ladders[nextR][nextC]) {
            return false;
        }

        nextC = c;
        if (inRange(nextR, nextC) && ladders[nextR][nextC]) {
            return false;
        }

        return true;
    }

    private static boolean inRange(int r, int c) {
        return r >= 1 && r <= h && c >= 1 && c < n;
    }

    private static boolean check() {
        for (int i = 1; i <= n; i++) {
            int currCol = i;
            int currRow = 1;

            while (true) {
                if (currRow > h) {
                    break;
                }

                // 좌우에 가로선이 있으면 이동
                if (inRange(currRow, currCol - 1) && ladders[currRow][currCol - 1]) {
                    currCol -= 1;
                } else if (inRange(currRow, currCol) && ladders[currRow][currCol]) {
                    currCol += 1;
                }
                currRow += 1;
            }

            if (i != currCol) {
                return false;
            }
        }

        return true;
    }
}