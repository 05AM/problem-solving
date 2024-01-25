import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private int solution(String s, String t) {
        int answer = 0;
        int tLength = t.length();

        HashMap<Character, Integer> tComposition = new HashMap<>();
        HashMap<Character, Integer> partComposition = new HashMap<>();

        for (char ch : t.toCharArray()) {
            tComposition.put(ch, tComposition.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < tLength - 1; i++) {
            partComposition.put(s.charAt(i), partComposition.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int rt = tLength - 1, lt = 0; rt < s.length(); rt++) {
            partComposition.put(s.charAt(rt), partComposition.getOrDefault(s.charAt(rt), 0) + 1);

            if (tComposition.equals(partComposition)) {
                answer++;
            }

            char keyToRemove = s.charAt(lt++);
            partComposition.put(keyToRemove, partComposition.get(keyToRemove) - 1);
            if (partComposition.get(keyToRemove) == 0) {
                partComposition.remove(keyToRemove);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        String s = in.next();
        String t = in.next();

        System.out.println(T.solution(s, t));
    }
}
