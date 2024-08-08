import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int h = in.nextInt();
        int w = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();

        int maxVerticalCnt = (1 + (w - 1) / (m + 1));
        int maxHorizontalCnt = (1 + (h - 1) / (n + 1));

        System.out.println(maxVerticalCnt * maxHorizontalCnt);
    }
}