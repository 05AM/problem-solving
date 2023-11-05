class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        
        if(num % 2 == 0) {
            int mid = num / 2 - 1;
            int midValue = total / num;
            int firstValue = midValue - (num / 2 - 1);
            
            for(int i = 0; i < num; i++) {
                answer[i] = firstValue++;
            }  
        } else {
            int mid = num / 2;
            int midValue = total / num;
            int firstValue = midValue - num / 2;
            
            for(int i = 0; i < num; i++) {
                answer[i] = firstValue++;
            }  
        }
        
        return answer;
    }
}