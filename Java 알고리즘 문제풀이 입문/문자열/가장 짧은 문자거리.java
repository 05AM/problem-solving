import java.util.Scanner;

public class Main {
    public String solution(String s, char t) {
        int[] distance = new int[s.length()];

        // 앞
        for (int i = 0, d = 1000; i < s.length(); i++) {
            if (s.charAt(i) == t) {
                d = 0;
                distance[i] = d;
            } else {
                distance[i] = ++d;
            }
        }

        // 뒤
        for (int i = s.length() - 1, d = 1000; i >= 0; i--) {
            if (s.charAt(i) == t) {
                d = 0;
            } else {
                distance[i] = Math.min(distance[i], ++d);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int d : distance) {
            sb.append(d).append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);
        String s = in.next();
        char t = in.next().charAt(0);

        System.out.println(T.solution(s, t));
    }
}
