class Solution {
    public int solution(int[][] dots) {
        int side1 = 0;
        int side2 = 0;
        
        for(int i = 0; i < dots.length; i++){
            int side1_tmp = Math.abs(dots[i][0] - dots[(i+1)% 4][0]);
            side1 = side1_tmp != 0 ? side1_tmp : side1;
            
            int side2_tmp = Math.abs(dots[i][1] - dots[(i+1)% 4][1]);
            side2 = side2_tmp != 0 ? side2_tmp : side2;
        }
        
        return side1 * side2;
    }
}