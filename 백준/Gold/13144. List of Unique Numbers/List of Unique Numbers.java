import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int MAX_NUM = 100000;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        StringTokenizer input = new StringTokenizer(in.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(input.nextToken());
        }

        long result = solution(n, arr);
        System.out.println(result);
    }

    private static long solution(int n, int[] arr) {
        int[] count = new int[MAX_NUM + 1];

        long answer = 0;
        for (int l = 1, r = 0; l <= n; l++) {
            while (r + 1 <= n && count[arr[r + 1]] == 0) {
                r++;
                count[arr[r]]++;
            }

            answer += r - l + 1;
            count[arr[l]]--;
        }

        return answer;
    }
}
