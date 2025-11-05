import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int max = Integer.MIN_VALUE;

    private static final int[] dr = new int[] {0, 1, 0, -1};
    private static final int[] dc = new int[] {1, 0, -1, 0};

    private static int r, c;
    private static char[][] map;
    private static final boolean[] isVisited = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = in.readLine().toCharArray();
        }

        isVisited[map[0][0] - 'A'] = true;
        solution(0, 0, 1);
        System.out.println(max);
    }

    private static void solution(int row, int col, int length) {
        max = Math.max(max, length);

        for (int i = 0; i < 4; i++) {
            int nextRow = row + dr[i];
            int nextCol = col + dc[i];

            if (!isInRange(nextRow, nextCol)) {
                continue;
            }

            int nextCharIdx = map[nextRow][nextCol] - 'A';
            if (!isVisited[nextCharIdx]) {
                isVisited[nextCharIdx] = true;
                solution(nextRow, nextCol, length + 1);
                isVisited[nextCharIdx] = false;
            }
        }
    }

    private static boolean isInRange(int row, int col) {
        return row >= 0 && row < r && col >= 0 && col < c;
    }
}