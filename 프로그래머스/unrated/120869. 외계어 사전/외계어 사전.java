import java.lang.StringBuilder;

class Solution {
    public int solution(String[] spells, String[] dic) {
        StringBuilder sb = new StringBuilder();
        String regex = sb.append("[^").append(String.join("", spells)).append("]").toString();

        for(String word : dic) {
            if(isContains(word.replaceAll(regex, ""), spells)) {
                return 1;
            }
        }
        return 2;
    }
    
    private boolean isContains(String word, String[] spells) {
        boolean contains = true;
        
        for(String spell : spells) {
            contains = contains && word.contains(spell);
        }
        
        return contains;
    }
}