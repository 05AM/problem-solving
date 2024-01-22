import java.util.Scanner;

public class Main {
    private int solution(int n, int k, int[] arr) {
        int answer = Integer.MIN_VALUE;
        int lt = 0, zero_cnt = 0, size = 0;

        // k개의 0을 포함하는 가장 긴 구간을 찾아라
        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) {
                zero_cnt++;
            }

            while (zero_cnt > k) {
                if (arr[lt++] == 0) {
                    zero_cnt--;
                }
            }

            size = rt - lt + 1;
            answer = Math.max(answer, size);
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(T.solution(n, k, arr));
    }
}
