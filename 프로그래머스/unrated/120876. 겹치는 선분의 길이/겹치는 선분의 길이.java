import java.util.*;

class Solution {
    public int solution(int[][] lines) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int[] line : lines) {
            int from = line[0];
            int to = line[1];
            
            for (int i = from; i < to; i++) {
                map.merge(i, 1, Integer::sum);
            }
        }

        return (int) map.values().stream().filter(i -> i > 1).count();
    }
}