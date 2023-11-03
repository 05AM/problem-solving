import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int[][] dots) {
        double slope1;
        double slope2;
        
        slope1 = calculateSlope(dots[0], dots[1]);
        slope2 = calculateSlope(dots[2], dots[3]);
        if(Double.compare(slope1, slope2) == 0) {
            return 1;
        }
        
        slope1 = calculateSlope(dots[0], dots[2]);
        slope2 = calculateSlope(dots[1], dots[3]);
        if(Double.compare(slope1, slope2) == 0) {
            return 1;
        }
        
        slope1 = calculateSlope(dots[0], dots[3]);
        slope2 = calculateSlope(dots[1], dots[2]);
        if(Double.compare(slope1, slope2) == 0) {
            return 1;
        }

        return 0;
    }

    private double calculateSlope(int[] dot1, int[] dot2) {
        return (double) (dot1[1] - dot2[1]) / (dot1[0] - dot2[0]);
    }
}