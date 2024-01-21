import java.util.Scanner;

public class Main {
    // 반복문으로 쉽게 풀 수 있으나, 복잡도가 너무 커져버림
    private int solution(int n, int m, int[] numbers) {
        int answer = 0;
        int sum = 0, lt = 0;

        // 구간 [lt, rt] 내의 원소의 합을 비교한다.
        for (int rt = 0; rt < n; rt++) {
            sum += numbers[rt];

            if (sum == m) {
                answer++;
            }

            // 합이 m보다 크거나 같으면, lt를 감소시키며 결과를 탐색한다.
            while (sum >= m) {
                sum -= numbers[lt++];
                if (sum == m) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = in.nextInt();
        }

        System.out.println(T.solution(n, m, numbers));
    }
}
