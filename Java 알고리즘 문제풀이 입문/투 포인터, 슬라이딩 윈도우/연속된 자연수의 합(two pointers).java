import java.util.Scanner;

public class Main {
    private int solution(int n) {
        int answer = 0;
        int sum = 0, lt = 1;

        for (int rt = 1; rt <= n / 2 + 1; rt++) {
            sum += rt;

            if (sum == n) {
                answer++;
            }

            while (sum >= n) {
                sum -= lt++;
                if (sum == n) {
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

        System.out.println(T.solution(n));
    }
}
