import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        int[] values = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            values[i] = in.nextInt();
        }

        int result = solution(k, values);
        System.out.println(result);
    }

    private static int solution(int k, int[] values) {
        int min = 0;

        for (int value : values) {
            if (k >= value) {
                int cnt = k / value;
                k %= value;

                min += cnt;
            }
        }

        if (k != 0) {
            throw new RuntimeException("최적해를 도출할 수 없습니다.");
        }

        return min;
    }
}