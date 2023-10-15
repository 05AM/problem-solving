import java.util.*;

class Solution {
    public int solution(String before, String after) {
        char[] before_arr = before.toCharArray();
        char[] after_arr = after.toCharArray();
        
        Arrays.sort(before_arr);
        Arrays.sort(after_arr);
        
        return String.valueOf(before_arr).equals(String.valueOf(after_arr)) ? 1 : 0;
    }
}