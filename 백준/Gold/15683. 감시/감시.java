import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class CCTV {
        int type;
        int row, col;

        public CCTV(int type, int row, int col) {
            this.type = type;
            this.row = row;
            this.col = col;
        }
    }

    static class CCTVStatus {
        CCTV cctv;
        int direction;

        public CCTVStatus(CCTV cctv, int direction) {
            this.cctv = cctv;
            this.direction = direction;
        }
    }

    static final int BLANK = 0;
    static final int WALL = 6;
    static final int MARK = -1;

    static final int[] dr = new int[] {-1, 0, 1, 0};
    static final int[] dc = new int[] {0, 1, 0, -1};

    static int n, m, k; // 사무실 세로, 가로, cctv 개수
    static int[][] map, mapForSimulation;
    static List<CCTV> cctvs;
    static CCTVStatus[] fixed;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        mapForSimulation = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(in.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        // CCTV 위치 찾기
        cctvs = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (isCCTV(map[r][c])) {
                    cctvs.add(new CCTV(map[r][c], r, c));
                }
            }
        }

        k = cctvs.size();
        fixed = new CCTVStatus[k];

        findMinBlindSpot(0);
        System.out.println(answer);
    }

    private static void findMinBlindSpot(int currIdx) {
        if (currIdx == k) {
            // 시뮬레이션 맵 만들기
            for (int i = 0; i < n; i++) {
                mapForSimulation[i] = map[i].clone();
            }

            // 현재 상태에서 사각지대 수 구하기
            for (int i = 0; i < k; i++) {
                CCTVStatus status = fixed[i];
                CCTV cctv = status.cctv;
                int direction = status.direction;
                int row = cctv.row;
                int col = cctv.col;

                switch (cctv.type) {
                    case 1:
                        move(row, col, direction);
                        break;
                    case 2:
                        move(row, col, direction);
                        move(row, col, (direction + 2) % 4);
                        break;
                    case 3:
                        move(row, col, direction);
                        move(row, col, (direction + 1) % 4);
                        break;
                    case 4:
                        move(row, col, direction);
                        move(row, col, (direction + 1) % 4);
                        move(row, col, (direction + 2) % 4);
                        break;
                    case 5:
                        for (int j = 0; j < 4; j++) {
                            move(row, col, j);
                        }
                        break;
                }
            }
            
            // 개수 세기
            int cnt = countBlank(mapForSimulation);
            // 최솟값 갱신
            answer = Math.min(answer, cnt);
        } else {
            CCTV cctv = cctvs.get(currIdx);

            switch (cctv.type) {
                case 1:
                case 3:
                case 4:
                    for (int i = 0; i < 4; i++) {
                        CCTVStatus status = new CCTVStatus(cctv, i);
                        fixed[currIdx] = status;
                        findMinBlindSpot(currIdx + 1);
                    }
                    break;
                case 2:
                    for (int i = 0; i < 2; i++) {
                        CCTVStatus status = new CCTVStatus(cctv, i);
                        fixed[currIdx] = status;
                        findMinBlindSpot(currIdx + 1);
                    }
                    break;
                case 5:
                    CCTVStatus status = new CCTVStatus(cctv, 0);
                    fixed[currIdx] = status;
                    findMinBlindSpot(currIdx + 1);
                    break;
            }
        }
    }

    private static int countBlank(int[][] map) {
        int cnt = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (map[r][c] == BLANK) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void move(int row, int col, int directionIdx) {
        while(true) {
            row += dr[directionIdx];
            col += dc[directionIdx];

            if (!inRange(row, col) || mapForSimulation[row][col] == WALL) {
                break;
            }
            mapForSimulation[row][col] = MARK;
        }
    }

    private static boolean isCCTV(int type) {
        return type >= 1 && type <= 5;
    }

    private static boolean inRange(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}