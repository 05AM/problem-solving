import java.util.*;

class Solution {
    public int solution(String before, String after) {
        boolean isPossible = true;
        
        Map<String, Integer> before_hm = new HashMap();
        Map<String, Integer> after_hm = new HashMap();
        
        for(char spell : before.toCharArray()) {
            String str = String.valueOf(spell);
            before_hm.put(str, before_hm.getOrDefault(str, 0) + 1);
        }
        
        for(char spell : after.toCharArray()) {
            String str = String.valueOf(spell);
            after_hm.put(str, after_hm.getOrDefault(str, 0) + 1);
        }
        
        for(Map.Entry<String, Integer> entry : after_hm.entrySet()) {                
            Integer beforeValue = before_hm.get(entry.getKey());
            
            if (beforeValue != null && beforeValue >= entry.getValue()) {
                continue;
            } else {
                isPossible = false;
                break;
            }
        }

        return isPossible ? 1 : 0;
    }
}