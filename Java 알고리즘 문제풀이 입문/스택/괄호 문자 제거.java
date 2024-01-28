import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {
    // 문자열에 누적하는 방법
    private String solution1(String s) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                stack.pop();
            } else {
                if (stack.isEmpty()) {
                    answer.append(ch);
                }
            }
        }
        return answer.toString();
    }

    // stack에 결과를 누적하는 방법
    private String solution2(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                while (stack.pop() != '(')
                    ;
            } else {
                stack.push(ch);
            }
        }
        return stack.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        String s = in.next();

        System.out.println(T.solution1(s));
        System.out.println(T.solution2(s));
    }
}
