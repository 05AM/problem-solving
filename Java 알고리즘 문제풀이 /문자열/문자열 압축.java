import java.util.Scanner;

public class Main {
    public String solution(String input) {
        StringBuilder answer = new StringBuilder();
        // Out Of Bound 에러를 막고, 마지막까지 정상적으로 실행되기 위해 빈 문자열 추가
        input += " ";

        for (int i = 0, cnt = 1; i < input.length() - 1; i++) {
            char now = input.charAt(i);
            char next = input.charAt(i + 1);

            if (now != next) {
                answer.append(now);
                if (cnt > 1) {
                    answer.append(cnt);
                }
                cnt = 1;
            } else {
                cnt++;
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);
        String input = in.next();

        System.out.println(T.solution(input));
    }
}
