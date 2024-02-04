import java.util.Scanner;
import java.util.Stack;

public class Main {
    private int solution(String s) {
        Stack<Character> stack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (s.charAt(i) == ')') {
                stack.pop();

                if (s.charAt(i - 1) == '(') {
                    // 레이저
                    answer += stack.size();
                } else {
                    // 파이프 끝
                    answer += 1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        String s = in.next();

        System.out.println(T.solution(s));
    }
}
