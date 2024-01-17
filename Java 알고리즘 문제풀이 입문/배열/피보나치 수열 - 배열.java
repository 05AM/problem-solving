import java.util.Scanner;

public class Main {
    public int[] solution(int n) {
        int[] fibonaccis = new int[n];
        fibonaccis[0] = 1;
        fibonaccis[1] = 1;

        for (int i = 2; i < n; i++) {
            fibonaccis[i] = fibonaccis[i - 1] + fibonaccis[i - 2];
        }
        return fibonaccis;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int number : T.solution(n)) {
            System.out.print(number + " ");
        }
    }
}
