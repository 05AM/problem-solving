import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int n = in.nextInt();

        int[] cables = new int[k];
        for (int i = 0; i < k; i++) {
            cables[i] = in.nextInt();
        }

        System.out.println(solution(k, n, cables));
    }

    private static long solution(int k, int n, int[] cables) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            max = Math.max(max, cables[i]);
        }

        long left = 1;
        long right = max;
        long answer = left;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (isAvailable(mid, n, cables)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private static boolean isAvailable(long length, int n, int[] cables) {
        long cnt = 0;
        for (int cable : cables) {
            cnt += cable / length;
        }
        return cnt >= n;
    }
}
