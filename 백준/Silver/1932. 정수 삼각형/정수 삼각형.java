
import java.util.Scanner;

public class Main {
    
    static int[][] dp;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int[][] triangle = new int[n][n];
        dp = new int[n + 1][n + 1];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                triangle[i][j] = in.nextInt();
            }
        }
        
        int answer = solution(n, triangle);
        System.out.println(answer);
    }
    
    private static int solution(int n, int[][] triangle) {
        for(int i = n - 1; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                int max = Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
                dp[i][j] = triangle[i][j] + max;
            }
        }
        
        return dp[0][0];
    }
}