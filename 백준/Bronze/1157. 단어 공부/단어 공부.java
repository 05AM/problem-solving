import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println(solution(in.next()));
    }

    public static Character solution(String input) {
        Map<Character, Integer> count = new HashMap<>();

        for (char ch : input.toCharArray()) {
            count.merge(Character.toLowerCase(ch), 1, Integer::sum);
        }

        Character answer = '?';
        int max = Integer.MIN_VALUE;

        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            if (entry.getValue() == max) {
                answer = '?';
            } else if (entry.getValue() > max) {
                answer = entry.getKey();
                max = entry.getValue();
            }
        }

        return Character.toUpperCase(answer);
    }
}