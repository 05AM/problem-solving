import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        solution(n);
    }

    private static void solution(int n) {
        int answer = -1;
        int cnt = 0;

        for (int i = 1; i <= Integer.MAX_VALUE; i++) {
            if (String.valueOf(i).contains("666")) {
                cnt++;

                if (cnt == n) {
                    answer = i;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}