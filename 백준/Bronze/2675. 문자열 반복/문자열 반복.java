import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 1; i <= t; i++) {
            int r = in.nextInt();
            String word = in.next();

            StringBuilder answer = new StringBuilder();

            for (char ch : word.toCharArray()) {
                answer.append(String.valueOf(ch).repeat(r));
            }

            System.out.println(answer);
        }
    }
}