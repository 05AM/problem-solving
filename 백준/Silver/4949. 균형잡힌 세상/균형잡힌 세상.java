import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = in.readLine();

            if (input.equals(".")) {
                break;
            }

            input = input.replaceAll("[a-zA-Z\\s\\.]", "");
            Stack<Character> stack = new Stack<>();
            String answer = "yes";

            for (char ch : input.toCharArray()) {
                if (ch == '(') {
                    stack.push(')');
                } else if (ch == '[') {
                    stack.push(']');
                } else {
                    if (stack.isEmpty() || stack.pop() != ch) {
                        answer = "no";
                        break;
                    }
                }
            }

            if (answer.equals("yes") && !stack.empty()) {
                answer = "no";
            }

            System.out.println(answer);
        }
    }
}