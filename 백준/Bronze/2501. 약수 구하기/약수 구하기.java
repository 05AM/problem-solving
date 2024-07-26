import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        System.out.println(solution(n, k));
    }

    private static int solution(int n, int k) {
        int answer = 0;
        int cnt = 0;
        
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                cnt++;

                if (cnt == k) {
                    answer = i;
                    break;
                }
            }
        }

        if (++cnt == k) {
            answer = n;
        }
        
        return answer;
    }
}