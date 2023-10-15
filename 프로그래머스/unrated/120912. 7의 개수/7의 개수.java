import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        for(int n : array) {
            for(char ch : String.valueOf(n).toCharArray()) {
                if(ch == '7')
                    answer++;
            }
        }
        return answer;
    }
}