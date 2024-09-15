import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[] sequence = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int max = solution(n, sequence);

        System.out.println(max);
    }

    private static int solution(int n, int[] sequence) {
        int currentSum = sequence[0];
        int max = sequence[0];

        for (int i = 1; i < n; i++) {
            currentSum = Math.max(currentSum + sequence[i], sequence[i]);
            max = Math.max(max, currentSum);
        }

        return max;
    }
}