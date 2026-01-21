import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int result = solution(n);
        System.out.println(result);
    }

    private static int solution(int n) {
        int cnt = 0;

        int left = 1;
        int right = 1;
        int sum = 1;

        while (left <= right) {
            if (sum < n) {
                right++;
                sum += right;
            } else {
                if (sum == n) {
                    cnt++;
                }
                sum -= left;
                left++;
            }
        }
        return cnt;
    }
}