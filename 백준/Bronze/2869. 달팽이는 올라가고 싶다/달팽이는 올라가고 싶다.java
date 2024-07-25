import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        int v = in.nextInt();

        System.out.println(solution(a, b, v));
    }

    private static int solution(int a, int b, int v) {
        return (int)Math.ceil((double)(v - b) / (a - b));
    }
}