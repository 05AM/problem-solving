import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        // 개수 세기
        Integer[] count = new Integer[10000000 + 1];
        Arrays.fill(count, 0);
        for (int size : tangerine) {
            count[size]++;
        }

        // 내림차순 정렬
        Arrays.sort(count, Comparator.reverseOrder());

        int answer = 0;
        for (int i = 0; i < count.length && k > 0; i++) {
            k -= count[i];
            answer++;
        }

        return answer;
    }
}