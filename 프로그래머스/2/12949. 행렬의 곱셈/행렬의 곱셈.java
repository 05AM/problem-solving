class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {        
        int m = arr1.length;
        int n = arr1[0].length;
        int p = arr2[0].length;
        
        int[][] answer = new int[m][p];
        
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < p; col++) {
                // 내적 구하기
                for (int i = 0; i < n; i++) {
                    answer[row][col] += arr1[row][i] * arr2[i][col];
                }
            }
        }
        
        return answer;
    }
}