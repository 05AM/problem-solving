import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] input = in.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] heights = Arrays.stream(in.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int result = solution(n, m, heights);
        System.out.println(result);
    }

    private static int solution(int n, int m, int[] heights) {
        int left = 0;
        int right = Arrays.stream(heights)
            .max()
            .getAsInt();

        int max = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            long result = 0;
            for (int height : heights) {
                int rest = height - mid;
                if (rest > 0) {
                    result += rest;
                }
            }

            if (result >= m) {
                max = Math.max(max, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return max;
    }
}