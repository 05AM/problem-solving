import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Map<Integer, Integer> count = new HashMap<>();
        int n = elements.length;
        
        for (int front = 0; front < n; front++) {
            int back = front;
            int sum = 0;
            int trial = 0;

            while (trial++ < n) {
                sum += elements[back];
                count.merge(sum, 1, Integer::sum);
                back = (back + 1) % n;
            }
        }

        return count.size();
    }
}