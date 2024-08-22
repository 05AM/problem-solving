import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while ((input = in.readLine()) != null) {
            answer.setLength(0);

            int n = Integer.parseInt(input);
            int cnt = (int) Math.pow(3, n);
            answer.append("-".repeat(cnt));

            solution(0, cnt);

            System.out.println(answer);
        }
    }

    private static void solution(int start, int length) {
        if (length == 1) {
            return;
        } else {
            int third = length / 3;
            int startIdx = start + third;
            int endIdx = start + third * 2;

            answer.replace(startIdx, endIdx, " ".repeat(third));

            solution(start, third);
            solution(endIdx, third);
        }
    }
}