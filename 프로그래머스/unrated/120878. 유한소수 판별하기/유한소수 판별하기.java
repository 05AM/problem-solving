class Solution {
    public int solution(int a, int b) {
        int limit = Math.min(a, b);

        for(int i = 1; i <= limit; i++) {
            if((a % i == 0) && (b % i == 0)) {
                a /= i;
                b /= i;
            }
        }

        while(b % 5 == 0) {
            b /= 5;
        }

        while(b % 2 == 0) {
            b /= 2;
        }
        
        return b == 1 ? 1 : 2;
    }
}