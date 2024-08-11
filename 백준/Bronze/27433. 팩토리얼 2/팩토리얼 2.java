import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(solution(n));
    }

    public static long solution(int n) {
        if (n == 0) {
            return 1L;
        } else {
            return n * solution(n - 1);
        }
    }
}