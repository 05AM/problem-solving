import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[][] scores) {
        List<Double> averages = Arrays.stream(scores)
                .map(score -> (score[0] + score[1]) / 2.0)
                .collect(Collectors.toList());

        List<Double> sortedAverages = new ArrayList<>(averages);
        sortedAverages.sort(Collections.reverseOrder());

        Map<Double, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for (double average : sortedAverages) {
            rankMap.putIfAbsent(average, rank);
            rank++;
        }

        int[] ranks = averages.stream()
                .map(rankMap::get)
                .mapToInt(i -> i)
                .toArray();

        return ranks;
    }
}