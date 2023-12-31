import java.util.ArrayList;

class Solution {
    public int solution(int[] sides) {
        ArrayList<Integer> possibleSides = new ArrayList<Integer>();

        int max = Math.max(sides[0], sides[1]);
        int min = Math.min(sides[0], sides[1]);
        
        int maxPossibleSide = max + min -1;
        int minPossibleSide = max - min + 1;
    
        
        return countNumbersInRange(minPossibleSide, maxPossibleSide);
    }
    
    private int countNumbersInRange(int min, int max) {
        return max - min + 1;
    }
}