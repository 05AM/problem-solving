import java.util.ArrayList;

class Solution {
    public int solution(int[] sides) {
        ArrayList<Integer> possibleSides = new ArrayList<Integer>();

        int max = Math.max(sides[0], sides[1]);
        int min = Math.min(sides[0], sides[1]);
        
        return (max + min -1) - (max - min + 1) + 1;
    }
}