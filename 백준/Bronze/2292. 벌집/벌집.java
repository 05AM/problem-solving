import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        System.out.println(solution(n));
    }

    private static int solution(int n) {
        int answer = 1;
        int criterion = 1;

        while (n > criterion) {
            criterion += (6 * answer);
            answer++;
        }

        return answer;
    }
}