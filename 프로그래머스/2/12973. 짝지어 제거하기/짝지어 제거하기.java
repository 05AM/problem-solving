import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }

            char top = stack.peek();

            char current = s.charAt(i);
            if (top == current) {
                stack.pop();
            } else {
                stack.push(current);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}