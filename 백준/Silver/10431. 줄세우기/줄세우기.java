import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        for (int i = 1; i <= n; i++) {
            int[] input = Arrays.stream(in.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            answer.append(i).append(" ").append(count(input)).append("\n");
        }

        System.out.println(answer);
    }

    private static int count(int[] input) {
        int cnt = 0;

        LinkedList<Integer> order = new LinkedList<>();
        order.add(input[1]);

        for (int i = 2; i <= 20; i++) {
            int idx = order.size();

            while (idx > 0) {
                if (input[i] > order.get(idx - 1)) {
                    break;
                }

                idx--;
            }

            order.add(idx, input[i]);
            cnt += (order.size() - 1) - idx;
        }

        return cnt;
    }
}