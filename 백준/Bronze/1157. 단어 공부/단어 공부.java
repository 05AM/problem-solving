import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println(solution(in.next()));
    }

    public static Character solution(String input) {
        int[] cnt = new int[26];
        int max = Integer.MIN_VALUE;
        char key = '?';

        for (char ch : input.toCharArray()) {
            ch = Character.toUpperCase(ch);
            int index = ch - 65;
            cnt[index]++;

            if (max == cnt[index]) {
                key = '?';
            } else if (max < cnt[index]) {
                key = ch;
                max = cnt[index];
            }
        }

        return key;
    }
}