import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] input = in.readLine().split(" ");
        int k = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        int[] lines = new int[k];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            lines[i] = Integer.parseInt(in.readLine());
            max = Math.max(max, lines[i]);
        }

        long left = 1;
        long right = max;
        long result = left;

        while (right >= left) {
            long mid = left + (right - left) / 2;

            long cnt = 0;
            for (int line : lines) {
                cnt += line / mid;
            }

            if (cnt >= n) {
                result = Math.max(result, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}