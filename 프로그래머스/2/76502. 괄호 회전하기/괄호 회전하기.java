import java.util.*;

class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder(s);

        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            // 문자열 왼쪽으로 회전
            char head = sb.toString().charAt(0);
            sb.deleteCharAt(0);
            sb.append(head);

            String str = sb.toString();
            Deque<Character> stack = new LinkedList<>();

            boolean isFail = false;

            // 올바른 괄호인지 확인
            for (char c : str.toCharArray()) {
                if (c == '[' || c == '{' || c == '(') {
                    stack.push(c);
                    continue;
                }

                if (stack.isEmpty()) {
                    isFail = true;
                    break;
                }

                char last = stack.peek();

                if ((last == '[' && c == ']') ||(last == '{' && c == '}') || (last == '(' && c == ')')) {
                    stack.pop();
                } else {
                    isFail = true;
                    break;
                }
            }

            if (!isFail && stack.isEmpty()) {
                answer++;
            }
        }

        return answer;
    }
}