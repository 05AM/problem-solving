import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] budgets = new int[n];
        int min = Integer.MIN_VALUE;
        int max = 0;
        for (int i = 0; i < n; i++) {
            budgets[i] = Integer.parseInt(in.readLine());
            min = Math.max(min, budgets[i]);
            max += budgets[i];
        }

        int answer = solution(m, min, max, budgets);
        System.out.println(answer);
    }

    private static int solution(int m, int min, int max, int[] budgets) {
        int left = min;
        int right = max;
        int result = right;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isAvailable(mid, m, budgets)) {
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private static boolean isAvailable(int amount, int cnt, int[] costs) {
        int usedCnt = 1;
        int sum = 0;

        for (int cost : costs) {
            if (cost > amount - sum) {
                if (usedCnt == cnt) {
                    return false;
                }
                sum = 0;
                usedCnt += 1;
            }
            sum += cost;
        }

        return true;
    }
}