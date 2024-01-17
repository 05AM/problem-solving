import java.util.Scanner;

public class Main {
    public int solution(int n) {
        int answer = 0;
        // 범위 2~n이기 때문에 n번 인덱스까지 생성
        int[] primes = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            // 0의 의미: 현재 숫자보다 작은 수 중에 약수가 없다 = 소수
            if (primes[i] == 0) {
                answer++;
                for (int j = i; j <= n; j += i) {
                    primes[j] = 1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(T.solution(n));
    }
}
