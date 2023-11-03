import java.util.Arrays;

class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] range = new int[201];
        
        for(int[] line : lines) {
            for(int num = line[0]; num < line[1]; num++) {
                range[num + 100] += 1; 
            }
        }
        
        for(int num : range) {
            if(num >= 2) {
                answer += 1;
            }
        }
        
        return answer;
    }
}