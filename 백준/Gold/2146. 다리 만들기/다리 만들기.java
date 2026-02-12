import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

    private static final int[] dr = new int[]{1, 0, -1, 0};
    private static final int[] dc = new int[]{0, 1, 0, -1};

    private static int n;
    private static int[][] map;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        map = new int[n][n];

        for (int row = 0; row < n; row++) {
            map[row] = Arrays.stream(in.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        // 섬 라벨링하기
        int islandId = 2;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (map[r][c] == 1) {
                    labelIsland(r, c, islandId);
                    islandId++;
                }
            }
        }

        findMinDist();
        System.out.println(min);
    }

    private static void labelIsland(int startR, int startC, int islandId) {
        map[startR][startC] = islandId;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startR, startC});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (notInRange(nr, nc)) {
                    continue;
                }

                if (map[nr][nc] == 1) {
                    map[nr][nc] = islandId;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
    }

    private static void findMinDist() {
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] owner = new int[n][n];
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        // 소유자, 거리 초기값 세팅
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (map[r][c] > 1) {
                    owner[r][c] = map[r][c];
                    dist[r][c] = 0;

                    // 끝점만 넣기
                    for (int i = 0; i < 4; i++) {
                        int nr = r + dr[i];
                        int nc = c + dc[i];

                        if (notInRange(nr, nc) || map[nr][nc] != 0) {
                            continue;
                        }

                        queue.offer(new int[]{r, c});
                        break;
                    }
                }
            }
        }

        // 최단거리 찾기
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            if (dist[r][c] >= min) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (notInRange(nr, nc)) {
                    continue;
                }

                if (dist[nr][nc] == -1) {
                    // 아직 아무도 도달하지 못한 지점일 때
                    owner[nr][nc] = owner[r][c];
                    dist[nr][nc] = dist[r][c] + 1;
                    queue.offer(new int[]{nr, nc});
                } else if (owner[nr][nc] != owner[r][c]) {
                    // 누군가 도달한 지점일 때 (충돌 시)
                    min = Math.min(min, dist[r][c] + dist[nr][nc]);
                }
            }
        }
    }

    private static boolean notInRange(int r, int c) {
        return r < 0 || r >= n || c < 0 || c >= n;
    }
}
