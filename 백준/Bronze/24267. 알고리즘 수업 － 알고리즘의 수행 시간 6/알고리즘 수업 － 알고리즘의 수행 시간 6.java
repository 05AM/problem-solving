import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();

        solution(n);
    }

    static void solution(long n) {
        long cnt = n * (n - 1) * (n - 2) / 6;

        System.out.println(cnt);
        System.out.println(3);
    }
}