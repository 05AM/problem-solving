import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner in = new Scanner(new InputStreamReader(System.in));

        int n = in.nextInt();
        int m = in.nextInt();

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = in.nextInt();
            }
        }

        System.out.println(solution(n, m, map));
    }

    private static int solution(int n, int m, int[][] map) {
        List<int[]> blanks = new ArrayList<>();
        List<int[]> viruses = new ArrayList<>();

        // 빈 칸, 바이러스 위치 리스트 업
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    blanks.add(new int[] {i, j});
                } else if (map[i][j] == 2) {
                    viruses.add(new int[] {i, j});
                }
            }
        }

        int blankCnt = blanks.size();
        int best = blankCnt - 3;
        int max = 0;

        Queue<int[]> queue = new ArrayDeque<>();
        List<int[]> modified = new ArrayList<>();

        // 3개 빈 칸 조합으로 벽 세우기
        for (int i = 0; i < blankCnt; i++) {
            if (max == best) {
                continue;
            }

            for (int j = i + 1; j < blankCnt; j++) {
                for (int k = j + 1; k < blankCnt; k++) {
                    // 벽 세우기
                    int[] wall1 = blanks.get(i);
                    int[] wall2 = blanks.get(j);
                    int[] wall3 = blanks.get(k);

                    map[wall1[0]][wall1[1]] = 1;
                    map[wall2[0]][wall2[1]] = 1;
                    map[wall3[0]][wall3[1]] = 1;

                    modified.add(wall1);
                    modified.add(wall2);
                    modified.add(wall3);

                    // 바이러스 지점에서 전파해서 안전구역 개수 구하기
                    for (int[] virus : viruses) {
                        queue.add(virus);
                    }

                    // 해당 조합으로 안전지대 최댓값 카운팅
                    int infectedCnt = 0;
                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();

                        for (int l = 0; l < 4; l++) {
                            int nextRow = current[0] + dx[l];
                            int nextCol = current[1] + dy[l];

                            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) {
                                continue;
                            }

                            if (map[nextRow][nextCol] != 0) {
                                continue;
                            }

                            map[nextRow][nextCol] = 2;
                            infectedCnt++;
                            queue.add(new int[] {nextRow, nextCol});
                            modified.add(new int[] {nextRow, nextCol});
                        }

                        // 이미 현재 최댓값보다 결과가 작으면
                        if (max >= (best - infectedCnt)) {
                            break;
                        }
                    }

                    // 최댓값 갱신
                    max = Math.max(max, best - infectedCnt);

                    // map 복원
                    for (int[] index : modified) {
                        map[index[0]][index[1]] = 0;
                    }

                    queue.clear();
                    modified.clear();
                }
            }
        }

        return max;
    }
}