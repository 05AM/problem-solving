import java.util.Scanner;

class Main {

    static final String FACTOR = "factor";
    static final String MULTIPLE = "multiple";
    static final String NEITHER = "neither";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n1 = in.nextInt();
        int n2 = in.nextInt();

        while (n1 != 0 && n2 != 0) {
            System.out.println(solution(n1, n2));

            n1 = in.nextInt();
            n2 = in.nextInt();
        }
    }

    private static String solution(int n1, int n2) {
        if ((n1 < n2) && (n2 % n1 == 0)) {
            return FACTOR;
        } else if ((n1 > n2) && (n1 % n2 == 0)) {
            return MULTIPLE;
        }

        return NEITHER;
    }
}