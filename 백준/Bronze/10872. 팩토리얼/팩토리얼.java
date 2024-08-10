import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(factorial(n));
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }

        int answer = 1;
        for (int i = 1; i <= n; i++) {
            answer *= i;
        }

        return answer;
    }
}