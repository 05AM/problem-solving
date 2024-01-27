import java.util.Scanner;
import java.util.Stack;

public class Main {
    private String solution(String s) {
        Stack<Character> brackets = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                brackets.push(ch);
            } else if (ch == ')') {
                if (brackets.isEmpty()) {
                    return "NO";
                }
                brackets.pop();
            }
        }

        return brackets.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        String s = in.next();

        System.out.println(T.solution(s));
    }
}
