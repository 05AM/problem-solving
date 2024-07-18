import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main {

    static Set<Integer> cards = new HashSet<>();
    static int[] numbers;

    public static void main(String[] args) {
        input();
        solution();
    }

    static void input() {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            cards.add(in.nextInt());
        }

        int m = in.nextInt();
        numbers = new int[m];

        for (int i = 0; i < m; i++) {
            numbers[i] = in.nextInt();
        }
    }

    private static void solution() {
        for (int num : numbers) {
            if (cards.contains(num)) {
                System.out.print(1 + " ");
            } else {
                System.out.print(0 + " ");
            }
        }
    }
}