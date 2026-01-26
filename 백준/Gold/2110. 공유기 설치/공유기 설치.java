import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] positions = new int[n];
        for (int i = 0; i < n; i++) {
            positions[i] = Integer.parseInt(in.readLine());
        }

        int result = solution(n, c, positions);
        System.out.println(result);
    }

    private static int solution(int n, int c, int[] positions) {
        Arrays.sort(positions);

        int right = positions[n - 1] - positions[0];
        int left = 1;
        int answer = left;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isAvailable(mid, c, positions)) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private static boolean isAvailable(int dist, int c, int[] positions) {
        int last = positions[0];
        int count = 1;

        for (int i = 0; i < positions.length; i++) {
            if (positions[i] - last >= dist) {
                count++;
                last = positions[i];
            }

            if (count == c) {
                return true;
            }
        }

        return false;
    }
}
