import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();


        System.out.println(fibonacciDynamic(n) + " " + (n - 3 + 1));
    }

    private static int fibonacciRecursion(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
    }

    private static int fibonacciDynamic(int n) {
        if (n <= 2) {
            return 1;
        }

        int[] memory = new int[n + 1];
        memory[1] = memory[2] = 1;

        for (int i = 3; i <= n; i++) {
            memory[i] = memory[i - 1] + memory[i - 2];
        }

        return memory[n];
    }
}