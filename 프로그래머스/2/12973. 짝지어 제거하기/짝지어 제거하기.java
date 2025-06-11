import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Deque<Character> stack = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}