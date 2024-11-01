import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[] times = Arrays.stream(in.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        System.out.println(solution(n, times));
    }

    private static int solution(int n, int[] times) {
        Arrays.sort(times);

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += times[i] * (n - i);
        }

        return result;
    }
}