import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        StringTokenizer input = new StringTokenizer(in.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input.nextToken());
        }

        int x = Integer.parseInt(in.readLine());

        int cnt = solution(arr, x);
        System.out.println(cnt);
    }

    private static int solution(int[] arr, int x) {
        // 크기가 1일 때 처리?
        int cnt = 0;

        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == x) {
                cnt++;
                right--;
                left++;
            } else if (sum > x) {
                right--;
            } else if (sum < x) {
                left++;
            }
        }

        return cnt;
    }
}
