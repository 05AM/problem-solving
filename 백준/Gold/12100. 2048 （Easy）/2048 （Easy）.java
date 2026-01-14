import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [알고리즘 선택 이유]
 * - 이동 횟수의 최대 깊이가 5로 매우 작다
 * - 매 단계에서 선택 가능한 방향이 상/하/좌/우 4개로 제한되어 있다
 * - 모든 경우를 시뮬레이션한 뒤 최종 보드에서 가장 큰 값만 비교하면 된다
 *
 * → 깊이가 얕고 분기 수가 작아 완전탐색(백트래킹)이 가능하다고 판단
 */

/**
 * [오답 노트]
 * - 부족한 점
 *   - 필요한 기능을 표준화해서 구현하는게 아직 안된다.
 *     - 예시) 숫자 압축을 전체 탐색이 아닌, 행/열 단위로 쪼개서 n^2로 구하기
 *     - 예시) 모든 방향에 대해 압축을 다 구현하는게 아니라, 보드 회전을 통해 로직 통일하기
 *   - 재귀 상황에서 공간 복잡도 파악이 어렵다.
 *     - 재귀의 공간 복잡도는 가장 깊은 레벨에서 최종 몇 개를 사용하고 있는지 판단하면 된다.
 *     - 예시) 이번 문제의 최대 깊이는 5, board는 매번 갈아끼워서 1, 매 깊이마다 base 배열 1. 따라서 1 + 5 + a
 *
 * [결론]
 * - 우선 시간/공간 복잡도를 생각하지 말고 기능을 최소 단위로 쪼개서 구현해보자.
 * - 시뮬레이션을 있는 그대로 재현하려고 하지말고, 가장 간단하고 효율적인 방법을 찾아보자. 
 */

public class Main {

    private static int max = Integer.MIN_VALUE;
    private static int n;
    private static int[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0);
        System.out.println(max);
    }

    private static void solution(int level) {
        if (level == 5) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    max = Math.max(max, board[r][c]);
                }
            }
            return;
        }

        int[][] base = deepCopy(board);

        for (int dir = 0; dir < 4; dir++) {
            board = rotateTimes(base, dir);
            simulateUp();
            solution(level + 1);
        }

        board = base;
    }

    private static void simulateUp() {
        for (int col = 0; col < n; col++) {
            int[] line = new int[n];

            // 압축 (0 제거)
            int idx = 0;
            for (int row = 0; row < n; row++) {
                if (board[row][col] != 0) {
                    line[idx++] = board[row][col];
                }
            }

            // 합치기
            for (int i = 0; i < n - 1; i++) {
                if (line[i] == 0) {
                    continue;
                }

                if (line[i] == line[i + 1]) {
                    line[i] *= 2;
                    line[i + 1] = 0;
                    i++;
                }
            }

            // 열 전체 0으로 초기화
            for (int row = 0; row < n; row++) {
                board[row][col] = 0;
            }

            // 다시 압축하면서 위부터 채우기
            idx = 0;
            for (int i = 0; i < n; i++) {
                if (line[i] != 0) {
                    board[idx++][col] = line[i];
                }
            }
        }
    }

    private static int[][] rotateTimes(int[][] src, int times) {
        int[][] result = deepCopy(src);
        for (int i = 0; i < times; i++) {
            result = rotateRight(result);
        }
        return result;
    }

    private static int[][] rotateRight(int[][] b) {
        int[][] rotated = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                rotated[col][n - 1 - row] = b[row][col];
            }
        }
        return rotated;
    }

    private static int[][] deepCopy(int[][] original) {
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            copy[i] = Arrays.copyOf(original[i], n);
        }
        return copy;
    }
}
