import java.util.Scanner;
import java.util.function.IntUnaryOperator;

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a1 = in.nextInt();
        int a0 = in.nextInt();
        int c = in.nextInt();
        int n0 = in.nextInt();

        System.out.println(solution(a1, a0, c, n0));
    }

    static int solution(int a1, int a0, int c, int n0) {
        IntUnaryOperator fn = n -> a1 * n + a0;
        IntUnaryOperator gn = n -> c * n;

        int answer = 1;
        for (int i = n0; i <= 100; i++) {
            if (fn.applyAsInt(i) > gn.applyAsInt(i)) {
                answer = 0;
                break;
            }
        }

        return answer;
    }
}