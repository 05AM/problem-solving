import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int x = in.nextInt();

        System.out.println(solution(x));
    }

    private static String solution(int x) {
        int level = 1;

        while (x > level) {
            x -= level;
            level++;
        }

        int n1 = 1;
        int n2 = level;

        for (int i = 1; i < x; i++) {
            n1++;
            n2--;
        }

        return level % 2 == 0 ? n1 + "/" + n2 : n2 + "/" + n1;
    }
}