import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        System.out.println(solution(n));
    }

    private static int solution(int n) {
        int dotsOnSide = 2;

        for (int i = 1; i <= n; i++) {
            dotsOnSide += (dotsOnSide - 1);
        }

        return (int)Math.pow(dotsOnSide, 2);
    }
}