import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;

        for (int i = 5; i <= n; i *= 5) {
            count += n / i;
        }

        System.out.println(count);
        in.close();
    }
}