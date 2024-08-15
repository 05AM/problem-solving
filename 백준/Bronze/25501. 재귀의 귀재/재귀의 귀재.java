import java.util.Scanner;

public class Main {
    public static void recursion(String s, int l, int r) {
        if (l >= r)
            System.out.println(1 + " " + (l + 1));
        else if (s.charAt(l) != s.charAt(r))
            System.out.println(0 + " " + (l + 1));
        else {
            recursion(s, l + 1, r - 1);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            String input = in.next();
            recursion(input, 0, input.length() - 1);
        }
    }
}