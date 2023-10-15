import java.util.*;

class Solution {
    public int solution(String my_string) {
        return Arrays.stream(my_string.split("\\D+"))
                .filter(s -> !s.equals(""))
                .map(Integer::parseInt)
                .mapToInt(i -> i).sum();
    }
}