import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Map<Integer, Integer> origin = new HashMap<>();
        for (int i = 0; i < n; i++) {
            origin.merge(in.nextInt(), 1, Integer::sum);
        }

        StringBuilder answer = new StringBuilder();
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int input = in.nextInt();

            answer.append(origin.getOrDefault(input, 0)).append(" ");
        }

        System.out.println(answer);
    }
}