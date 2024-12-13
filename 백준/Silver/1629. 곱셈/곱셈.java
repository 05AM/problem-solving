import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        long result = solution(a, b, c);
        System.out.println(result);

        in.close();
    }

    private static long solution(int a, int b, int c) {
        if (b == 0) {
            return 1;
        }

        long half = solution(a, b / 2, c);
        long result = half * half % c;

        if (b % 2 != 0) {
            result = result * a % c;
        }

        return result;
    }
}