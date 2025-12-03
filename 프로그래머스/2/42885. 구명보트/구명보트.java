import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int answer = 0;
        int left = 0;
        int right = people.length - 1;
        
        while (left <= right) {
            if (left == right) {
                answer += 1;
                break;
            }
            
            if (people[right] + people[left] <= limit) {
                answer += 1;
                left++;
                right--;
            } else {
                answer += 1;
                right--;
            }
        }
        
        return answer;
    }
}