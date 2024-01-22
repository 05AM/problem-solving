import java.util.Scanner;

public class Main {
    private int solution(int n) {
        int answer = 0;
        // 2개 이상의 연속된 자연수의 합
        // 아래 처리를 해주지 않으면 n 자체(cnt == 1)일 때도 포함이 되기 때문에 미리 빼준다.
        int cnt = 1;
        n--;

        while (n > 0) {
            n -= ++cnt;

            if (n % cnt == 0) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(T.solution(n));
    }
}
