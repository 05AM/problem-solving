import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Deque<Character> stack = new LinkedList<>();
        
        for(char c : s.toCharArray()) {
            if (stack.isEmpty() || c == '(') {
                stack.push(c);
                continue;
            }
            
            char prev = stack.pop();
        }

        return stack.isEmpty();
    }
}