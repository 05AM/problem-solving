import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(solution(n));

    }

    private static int solution(int n) {
        int cnt_3 = 0;
        int cnt_5 = n / 5;
        int rest = n % 5;

        if (rest == 0) {
            return cnt_5;
        }

        while (cnt_5 >= 0) {
            if (rest % 3 == 0) {
                cnt_3 = rest / 3;
                break;
            } else {
                cnt_5--;
                rest += 5;
            }
        }

        return cnt_5 >= 0 ? cnt_3 + cnt_5 : -1;
    }
}