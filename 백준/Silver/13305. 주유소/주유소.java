import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();
        long[] distances = new long[n - 1];
        long[] costs = new long[n];

        for (int i = 0; i < n - 1; i++) {
            distances[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            costs[i] = in.nextInt();
        }

        System.out.println(solution(n, distances, costs));
    }

    private static long solution(int n, long[] distances, long[] costs) {
        long sum = 0;
        long currentMinCost = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            if (costs[i] >= currentMinCost) {
                sum += currentMinCost * distances[i];
            } else {
                currentMinCost = costs[i];
                sum += currentMinCost * distances[i];
            }
        }

        return sum;
    }
}