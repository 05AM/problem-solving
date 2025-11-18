import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        // Please write your code here.
        int[] dayForMonths = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        int days = 0;
        for (int i = m1; i < m2; i++) {
            days += dayForMonths[i];
        }

        days -= d1;
        days += d2;
        days += 1;

        System.out.println(days);
    }
}