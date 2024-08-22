import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final String QUEUE = "0";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        in.readLine();
        String[] types = in.readLine().split(" ");
        String[] values = in.readLine().split(" ");

        in.readLine();
        String[] sequence = in.readLine().split(" ");

        solution(types, values, sequence);
    }

    private static void solution(String[] types, String[] values, String[] sequence) {
        StringBuilder result = new StringBuilder();
        int cnt = 0;

        for (int i = types.length - 1; i >= 0; i--) {
            if (cnt == sequence.length) {
                break;
            }

            if (types[i].equals(QUEUE)) {
                result.append(values[i]).append(" ");
                cnt++;
            }
        }

        if (cnt < sequence.length) {
            for (int i = 0; i < sequence.length - cnt; i++) {
                result.append(sequence[i]).append(" ");
            }
        }

        System.out.println(result);
    }
}