import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {

    static final String PERFECT = "%d = %s";
    static final String NOT_PERFECT = "%d is NOT perfect.";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        while (n != -1) {
            System.out.println(solution(n));
            n = in.nextInt();
        }
    }

    private static String solution(int n) {
        List<Integer> factors = new ArrayList<>();

        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }

        int sum = factors.stream()
                .mapToInt(Integer::intValue)
                .sum();

        if (sum == n) {
            return String.format(
                    PERFECT, 
                    n, 
                    factors.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(" + ")));
        } else {
            return String.format(NOT_PERFECT, n);
        }
    }
}