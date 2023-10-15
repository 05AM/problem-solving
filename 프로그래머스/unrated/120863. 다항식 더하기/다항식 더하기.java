import java.util.*;

class Solution {
    public String solution(String polynomial) {
        String[] operands = polynomial.split("\\s\\+\\s");

        int coefficient0 = 0;
        int coefficient1 = 0;
        
        for(String term : operands) {
            if(term.endsWith("x")) {
                if(term.equals("x"))
                    coefficient1 += 1;
                else
                    coefficient1 += Integer.parseInt(term.replace("x", ""));
            }
            else {
                coefficient0 += Integer.parseInt(term);
            }
        }
        
        StringBuilder answer = new StringBuilder();
        
        if(coefficient1 != 0) {
            if(coefficient1 != 1)
                answer.append(coefficient1);
            answer.append("x");
            
            if(coefficient0 != 0) {
                 answer.append(" + ");
                 answer.append(coefficient0);
             }
        } else {
            if(coefficient0 != 0)
                answer.append(coefficient0);
        }
        
        return answer.toString();
    }
}