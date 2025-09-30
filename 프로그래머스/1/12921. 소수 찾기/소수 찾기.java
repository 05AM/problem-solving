import java.util.*;

class Solution {
    public int solution(int n) {        
        boolean[] isPrimeNumber = new boolean[n + 1];
        Arrays.fill(isPrimeNumber, true);
        
        int notPrimeCnt = 0;
        for (int i = 2; i * i <= n; i++) {
            if (isPrimeNumber[i]) {
                for (int j = i; i * j <= n; j++) {
                    int next = i * j;
                    
                    if (isPrimeNumber[next]) {
                        notPrimeCnt++;
                        isPrimeNumber[next] = false;
                    }
                }
            }
        }
        
        return n - notPrimeCnt - 1;
    }
}