import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int k = Integer.parseInt(in.readLine());

        int result = findKthNumber(n, k);
        System.out.println(result);
    }

    private static int findKthNumber(int n, int k) {
        int left = 1;
        int right = k;

        int answer = left;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            int cnt = countLessOrEqual(n, mid);
            if (cnt >= k) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private static int countLessOrEqual(int n, int x) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            cnt += Math.min(x / i, n);
        }

        return cnt;
    }
}