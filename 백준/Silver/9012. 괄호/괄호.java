import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        for (int i = 0; i < n; i++) {
            String answer = "YES";
            Stack<Character> stack = new Stack<>();
            char[] input = in.readLine().toCharArray();

            for (char ch : input) {
                if (ch == '(') {
                    stack.push(ch);
                } else if (ch == ')') {
                    if (stack.isEmpty()) {
                        answer = "NO";
                        break;
                    }

                    stack.pop();
                }
            }

            if (answer.equals("YES")) {
                answer = stack.isEmpty() ? "YES" : "NO";
            }

            System.out.println(answer);
        }
    }
}