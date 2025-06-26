import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();

        int s = in.nextInt();
        int m = in.nextInt();
        int l = in.nextInt();
        int xl = in.nextInt();
        int xxl = in.nextInt();
        int xxxl = in.nextInt();

        int t = in.nextInt();
        int p = in.nextInt();

        // 티셔츠
        int tCnt = 0;
        tCnt += (s % t) == 0 ? (s / t) : (s / t) + 1;
        tCnt += (m % t) == 0 ? (m / t) : (m / t) + 1;
        tCnt += (l % t) == 0 ? (l / t) : (l / t) + 1;
        tCnt += (xl % t) == 0 ? (xl / t) : (xl / t) + 1;
        tCnt += (xxl % t) == 0 ? (xxl / t) : (xxl / t) + 1;
        tCnt += (xxxl % t) == 0 ? (xxxl / t) : (xxxl / t) + 1;

        // 펜
        int pCnt = n / p;
        int pRest = n % p;

        System.out.println(tCnt);
        System.out.println(pCnt + " " + pRest);
    }
}
