import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, s;
    static int answer = 0;
    static int[] sequence;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        sequence = Arrays.stream(in.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        count(0, 0);

        if (s == 0) {
            answer--;
        }
        System.out.println(answer);
    }

    private static void count(int i, int value) {
        if (i == n) {
            if (value == s) {
                answer++;
            }
        } else {
            count(i + 1, value + sequence[i]);
            count(i + 1, value);
        }
    }
}