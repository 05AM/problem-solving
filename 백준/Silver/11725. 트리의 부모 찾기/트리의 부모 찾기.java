import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 1; i <= n - 1; i++) {
            int from = in.nextInt();
            int to = in.nextInt();

            tree.get(from).add(to);
            tree.get(to).add(from);
        }

        solution(n, tree);
    }

    private static void solution(int n, List<List<Integer>> tree) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        int[] result = new int[n + 1];

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int i : tree.get(current)) {
                if (result[i] == 0) {
                    result[i] = current;
                    queue.add(i);
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            System.out.println(result[i]);
        }
    }
}