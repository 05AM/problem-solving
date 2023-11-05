class Solution {
    public int solution(int[] common) {
        int answer = 0;
        
        int first = common[0];
        int second = common[1];
        int third = common[2];
        
        int diff = second - first;
        int ratio = first != 0 ? second / first : 1;
        
        if(first + diff == second && second + diff == third) {
            answer = common[common.length - 1] + diff;
        } else if(first * ratio == second && second * ratio == third) {
            answer = common[common.length - 1] * ratio;
        }
        
        return answer;
    }
}