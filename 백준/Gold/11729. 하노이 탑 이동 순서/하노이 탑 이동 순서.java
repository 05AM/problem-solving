import java.util.Scanner;

public class Main {

    static StringBuilder movement = new StringBuilder();
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        hanoi(n, 1, 3, 2);
        System.out.println(cnt);
        System.out.println(movement);
    }

    public static void hanoi(int n, int source, int target, int auxiliary) {
        if (n == 1) {
            cnt++;
            movement.append(source + " " + target).append("\n");
            return;
        }

        hanoi(n - 1, source, auxiliary, target);
        cnt++;
        movement.append(source + " " + target).append("\n");
        hanoi(n - 1, auxiliary, target, source);
    }
}