import java.util.Scanner;
import java.util.stream.LongStream;

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();

        solution(n);
    }

    static void solution(long n) {
        long cnt = LongStream.range(1, n)
                .map(l -> n - l)
                .sum();

        System.out.println(cnt);
        System.out.println(2);
    }
}