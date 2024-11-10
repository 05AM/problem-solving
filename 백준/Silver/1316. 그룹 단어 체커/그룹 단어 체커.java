import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = in.next();
        }

        System.out.println(solution(words));
    }

    public static int solution(String[] words) {
        int cnt = 0;
        boolean[] isAppeared = new boolean[26];

        for (String word : words) {
            Arrays.fill(isAppeared, false);

            boolean isSerial = true;
            char last = word.charAt(0);
            isAppeared[last - 'a'] = true;

            for (int i = 1; i < word.length(); i++) {
                char now = word.charAt(i);
                int index = now - 'a';

                if (isAppeared[index] && (last != now)) {
                    isSerial = false;
                    break;
                }

                isAppeared[index] = true;
                last = now;
            }

            if (isSerial) {
                cnt++;
            }
        }

        return cnt;
    }
}