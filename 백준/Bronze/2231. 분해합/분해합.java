import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        System.out.println(solution(n));
    }

    private static int solution(int n) {
        int size = 9 * String.valueOf(n).length();
        int start = Math.max((n - size), 0);

        for (int i = start; i < n; i++) {
            if (getDecompositionSum(i) == n) {
                return i;
            }
        }

        return 0;
    }

    private static int getDecompositionSum(int n) {
        String str = String.valueOf(n);

        int digitSum = 0;
        for (char digit : str.toCharArray()) {
            digitSum += Character.getNumericValue(digit);
        }

        return n + digitSum;
    }
}