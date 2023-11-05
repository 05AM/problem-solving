import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        List<Integer> numbers = IntStream.of(numlist)
            .mapToObj(i -> i - n)
            .collect(Collectors.toList());

        numbers.sort((a, b) -> Integer.compare(Math.abs(a), Math.abs(b)));
        
        int[] answer = new int[numbers.size()];
        
        for(int i = 0; i <= numbers.size() - 1; i++) {
            if(i < numbers.size() - 1) {
                int now = numbers.get(i);
                int next = numbers.get(i + 1);

                if(Math.abs(now) == Math.abs(next)) {
                    if(now < next) {
                        answer[i + 1] = now + n;
                        answer[i] = next + n;
                    } else {
                        answer[i] = now + n;
                        answer[i + 1] = next + n;
                    }
                    i++;
                } else {
                    answer[i] = numbers.get(i) + n;
                }
            } else {
                answer[i] = numbers.get(i) + n;   
            }
        }
        
        return answer;
    }
}