import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String expr = in.readLine();

        StringBuilder result = new StringBuilder();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char c : expr.toCharArray()) {
            // 피연산자일 때
            if (Character.isAlphabetic(c)) {
                result.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            }

            // 연산자일 때
            else {
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
                    if (stack.peek() == '(') break;
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        System.out.println(result);
    }

    // 연산자 우선순위 반환
    private static int priority(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }
}
