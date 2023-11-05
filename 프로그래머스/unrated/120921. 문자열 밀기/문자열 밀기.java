import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String A, String B) {
        int answer = -1;

        Deque<String> a = new ArrayDeque<>(Arrays.stream(A.split("")).collect(Collectors.toList()));
        Deque<String> b = new ArrayDeque<>(Arrays.stream(B.split("")).collect(Collectors.toList()));

        for(int i = 0; i < A.length(); i++) {
            String resultA = String.join("", a);
            String resultB = String.join("", b);

            if(resultA.equals(resultB)) {
                answer = i;
                break;
            }
            a.addFirst(a.removeLast());
        }
        return answer;
    }
}