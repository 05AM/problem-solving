import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();

        solution(str);
    }

    public static void solution(String str) {
        Set<String> subs = new HashSet<>();

        for (int i = 1; i <= str.length(); i++) {
            for (int j = 0; j <= str.length() - i; j++) {
                String sub = str.substring(j, j + i);

                subs.add(sub);
            }
        }

        System.out.println(subs.size());
    }
}