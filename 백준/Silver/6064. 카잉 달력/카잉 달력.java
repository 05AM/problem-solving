import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        while (T-- > 0) {
            int m = in.nextInt();
            int n = in.nextInt();

            int x = in.nextInt();
            int y = in.nextInt();

            int lcm = lcm(m, n);
            int count = x;

            while (count <= lcm) {
                int k = count % n;
                if (k == 0) {
                    k = n;
                }
                
                if (k == y) {
                    break;
                }

                count += m;
            }

            if (count > lcm) {
                count = -1;
            }

            System.out.println(count);
        }
    }

    // 최대공약수
    public static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    // 최소공배수
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}