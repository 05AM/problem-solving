class Solution {
    public int solution(int n) {
        int div = 1234567;
        int[] result = new int[n + 1];
        result[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            result[i] = (result[i - 1] + result[i - 2]) % div;
        }
        
        return result[n];
    }
}