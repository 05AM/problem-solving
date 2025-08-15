import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R, C, T;
    static int[][] map;
    static int upper, lower; // 공기청정기 두 행 (열은 0)

    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        int purifierFound = 0;
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == -1) {
                    if (purifierFound == 0) {
                        upper = r;
                        purifierFound = 1;
                    } else {
                        lower = r;
                    }
                }
            }
        }

        for (int t = 0; t < T; t++) {
            spread();
            purify();
        }

        System.out.println(totalDust());
    }

    // 먼지 확산: 이번 턴 변화량을 temp에 누적 후 일괄 반영
    static void spread() {
        int[][] temp = new int[R][C];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] <= 0) continue; // 공기청정기(-1) 또는 먼지 없음(0)
                int amount = map[r][c] / 5;
                if (amount == 0) continue;

                int outCnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                    if (map[nr][nc] == -1) continue;
                    temp[nr][nc] += amount;
                    outCnt++;
                }
                temp[r][c] -= amount * outCnt;
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                map[r][c] += temp[r][c];
            }
        }
    }

    // 공기청정기 작동: 상단 반시계, 하단 시계
    static void purify() {
        // 상단(반시계)
        for (int r = upper - 1; r > 0; r--) map[r][0] = map[r - 1][0];
        for (int c = 0; c < C - 1; c++) map[0][c] = map[0][c + 1];
        for (int r = 0; r < upper; r++) map[r][C - 1] = map[r + 1][C - 1];
        for (int c = C - 1; c > 1; c--) map[upper][c] = map[upper][c - 1];
        map[upper][1] = 0;

        // 하단(시계)
        for (int r = lower + 1; r < R - 1; r++) map[r][0] = map[r + 1][0];
        for (int c = 0; c < C - 1; c++) map[R - 1][c] = map[R - 1][c + 1];
        for (int r = R - 1; r > lower; r--) map[r][C - 1] = map[r - 1][C - 1];
        for (int c = C - 1; c > 1; c--) map[lower][c] = map[lower][c - 1];
        map[lower][1] = 0;

        // 공기청정기 위치 유지
        map[upper][0] = -1;
        map[lower][0] = -1;
    }

    static int totalDust() {
        int sum = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] > 0) sum += map[r][c];
            }
        }
        return sum;
    }
}
