public class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean isStart = true;

        for (char c : s.toCharArray()) {
            if (isStart) {
                answer.append(Character.toUpperCase(c));
            } else {
                answer.append(Character.toLowerCase(c));
            }
            isStart = (c == ' ');
        }

        return answer.toString();
    }
}