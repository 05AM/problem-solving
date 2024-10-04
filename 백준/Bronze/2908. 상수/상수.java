import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        StringBuilder s1 = new StringBuilder(in.next());
        StringBuilder s2 = new StringBuilder(in.next());

        int n1 = Integer.parseInt(s1.reverse().toString());
        int n2 = Integer.parseInt(s2.reverse().toString());

        int answer = Integer.compare(n1, n2) > 0 ? n1 : n2;
        System.out.println(answer);
    }
}