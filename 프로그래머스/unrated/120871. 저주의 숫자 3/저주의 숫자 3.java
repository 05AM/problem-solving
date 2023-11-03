import java.util.regex.Pattern;

class Solution {
    public int solution(int n) {
        int num3x = 0;

        for(int i = 1; i <= n; i++) {
            num3x++;

            while(validate(num3x)) {
                num3x++;
            }
        }

        return num3x;
    }

    private boolean validate(int n) {
        return (n % 3 == 0) || String.valueOf(n).contains("3");
    }
}