import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();

        solution(n);
    }

    static void solution(long n) {
        System.out.println(n * n * n);
        System.out.println(3);
    }
}