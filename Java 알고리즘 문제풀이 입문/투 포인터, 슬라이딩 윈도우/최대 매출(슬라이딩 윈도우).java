import java.util.Scanner;

public class Main {
    private int solution(int n, int k, int[] incomes) {
        // 2중 for 문을 사용하면 입력 값의 크기에 따라 복잡도가 커짐: k^(n-k) -> k^2의 복잡도
        int answer, sum = 0;
        for (int i = 0; i < k; i++) {
            sum += incomes[i];
        }
        answer = sum;

        for (int i = k; i < n; i++) {
            sum = sum - incomes[i - k] + incomes[i];
            answer = Math.max(sum, answer);
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        int[] incomes = new int[n];
        for (int i = 0; i < n; i++) {
            incomes[i] = in.nextInt();
        }

        System.out.println(T.solution(n, k, incomes));
    }
}
