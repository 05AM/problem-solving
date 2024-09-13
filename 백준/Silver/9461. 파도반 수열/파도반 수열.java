import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int range = 100;
    static long[] p = new long[range + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        solution();

        int t = Integer.parseInt(in.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(in.readLine());

            System.out.println(p[n]);
        }
    }

    private static void solution() {
        p[1] = 1;
        p[2] = 1;
        p[3] = 1;

        for (int i = 4; i <= 100; i++) {
            p[i] = p[i - 3] + p[i - 2];
        }
    }
}