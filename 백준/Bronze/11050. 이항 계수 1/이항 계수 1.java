import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        System.out.println(binomial_coefficient(n, k));
    }

    public static int binomial_coefficient(int n, int k) {
        int numerator = 1;
        int denominator = 1;

        for (int i = n, j = k; i > (n - k); i--, j--) {
            numerator *= i;
            denominator *= j;
        }

        return numerator / denominator;
    }
}