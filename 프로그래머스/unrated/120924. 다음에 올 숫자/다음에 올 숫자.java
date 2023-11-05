class Solution {
    public int solution(int[] common) {
        int diff1 = common[1] - common[0];
        int diff2 = common[2] - common[1];
        
        if(diff1 == diff2) {
            return common[common.length - 1] + diff1;
        } else {
            return common[common.length - 1] * (common[1] / common[0]);
        }
    }
}