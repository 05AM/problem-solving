import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Set<String> used = new HashSet<>();
        used.add(words[0]);

        for(int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String current = words[i];

            char lastChar = prev.charAt(prev.length() - 1);
            char firstChar = current.charAt(0);

            if (used.contains(current) || lastChar != firstChar) {
                return new int[] { (i % n) + 1, (i / n) + 1 };
            }

            used.add(current);
        }

        return answer;
    }
}