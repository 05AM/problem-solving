import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        long[] solutions = Arrays.stream(in.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        getZeroClose(solutions);
        in.close();
    }

    private static void getZeroClose(long[] solutions) {
        Arrays.sort(solutions);

        int front = 0;
        int back = solutions.length - 1;

        long s1 = solutions[front];
        long s2 = solutions[back];
        long zeroCloseSum = s1 + s2;

        while (front < back) {
            long sum = solutions[front] + solutions[back];

            if (Math.abs(sum) < Math.abs(zeroCloseSum)) {
                s1 = solutions[front];
                s2 = solutions[back];
                zeroCloseSum = sum;

                if (sum == 0) {
                    break;
                }
            }

            if (sum > 0) {
                back--;
            } else {
                front++;
            }
        }

        System.out.println(s1 + " " + s2);
    }
}