import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        
        int first_max = numbers[0] * numbers[1];
        int last_max = numbers[numbers.length - 2] * numbers[numbers.length - 1];
        
        return first_max > last_max ? first_max : last_max;
    }
}