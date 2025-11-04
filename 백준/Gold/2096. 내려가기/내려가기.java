import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    private static final int LEFT = 0;
    private static final int MID = 1;
    private static final int RIGHT = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        int[][] map = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());

            map[i][LEFT] = Integer.parseInt(st.nextToken());
            map[i][MID] = Integer.parseInt(st.nextToken());
            map[i][RIGHT] = Integer.parseInt(st.nextToken());
        }

        // 최대 점수
        int[][] max = new int[n][3];
        int[][] min = new int[n][3];

        max[0][LEFT] = map[0][LEFT];
        max[0][MID] = map[0][MID];
        max[0][RIGHT] = map[0][RIGHT];

        min[0][LEFT] = map[0][LEFT];
        min[0][MID] = map[0][MID];
        min[0][RIGHT] = map[0][RIGHT];

        for (int i = 1; i < n; i++) {
            int left = map[i][LEFT];
            int mid = map[i][MID];
            int right = map[i][RIGHT];

            // 왼쪽
            max[i][LEFT] = Math.max(max[i - 1][LEFT], max[i - 1][MID]) + map[i][LEFT];
            min[i][LEFT] = Math.min(min[i - 1][LEFT], min[i - 1][MID]) + map[i][LEFT];

            // 가운데
            max[i][MID] = Math.max(Math.max(max[i - 1][LEFT], max[i - 1][MID]), max[i - 1][RIGHT]) + map[i][MID];
            min[i][MID] = Math.min(Math.min(min[i - 1][LEFT], min[i - 1][MID]), min[i - 1][RIGHT]) + map[i][MID];

            // 오른쪽
            max[i][RIGHT] = Math.max(max[i - 1][RIGHT], max[i - 1][MID]) + map[i][RIGHT];
            min[i][RIGHT] = Math.min(min[i - 1][RIGHT], min[i - 1][MID]) + map[i][RIGHT];
        }

        int maxSum = Arrays.stream(max[n - 1]).max().getAsInt();
        int minSum = Arrays.stream(min[n - 1]).min().getAsInt();

        System.out.print(maxSum + " " + minSum);
    }
}
