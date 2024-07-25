import java.util.Scanner;

class Main {

    static int QUARTER = 25;
    static int DIME = 10;
    static int NICKEL = 5;
    static int PENNY = 1;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int change = in.nextInt();

            System.out.println(solution(change));
        }
    }

    private static String solution(int change) {
        StringBuilder answer = new StringBuilder();

        answer.append(change / QUARTER).append(" ");
        change %= QUARTER;

        answer.append(change / DIME).append(" ");
        change %= DIME;

        answer.append(change / NICKEL).append(" ");
        change %= NICKEL;

        answer.append(change / PENNY).append(" ");
        change %= PENNY;

        return answer.toString();
    }
}