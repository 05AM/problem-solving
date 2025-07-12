import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
int[] answer = new int[2];

        Set<String> used = new HashSet<>();
        int order = 2;
        int round = 1;

        used.add(words[0]);
        String last = words[0];

        for(int i = 1; i < words.length; i++) {
            String word = words[i];

            char lastChar = last.charAt(last.length() - 1);
            char firstChar = word.charAt(0);

            if (used.contains(word) || lastChar != firstChar) {
                return new int[] { order, round };
            }

            used.add(word);
            last = word;
            order = (order + 1) % (n + 1);

            if (order == 0) {
                order++;
                round++;
            }
        }

        return answer;
    }
}