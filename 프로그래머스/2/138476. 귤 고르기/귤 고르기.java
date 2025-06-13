import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        // 개수 세기
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int size : tangerine) {
            countMap.merge(size, 1, Integer::sum);
        }

        // 내림차순 정렬
        List<Integer> counts = new ArrayList<>(countMap.values());
        counts.sort(Comparator.reverseOrder());

        int answer = 0;
        for (int count : counts) {
            k -= count;
            answer++;

            if (k <= 0) {
                break;
            }
        }

        return answer;
    }
}