class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int)(right - left + 1);
        int[] answer = new int[size];
        
        int answerIdx = 0;
        for (long i = left; i <= right; i++) {
            long row = i / n;
            long col = i % n;
            
            int value = (int)Math.max(row, col) + 1;
            answer[answerIdx++] = value;
        }
        
        return answer;
    }
}