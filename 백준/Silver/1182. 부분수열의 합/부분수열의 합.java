import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] input = in.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);

        int[] sequence = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(sequence);

        solution(0, 0, n, s, sequence);

        if (s == 0) {
            answer--;
        }

        System.out.println(answer);
    }

    private static void solution(int index, int sum, int n, int s, int[] sequence) {
        if (index == n) {
            if (sum == s) {
                answer++;
            }
            return;
        }

        solution(index + 1, sum + sequence[index], n, s, sequence);
        solution(index + 1, sum, n, s, sequence);
    }
}