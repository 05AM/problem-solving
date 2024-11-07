import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();
        int[] distances = Arrays.stream(in.nextLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int[] costs = Arrays.stream(in.nextLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        System.out.println(solution(n, distances, costs));
    }

    private static int solution(int n, int[] distances, int[] costs) {
        costs[n - 1] = Integer.MAX_VALUE;
        int minCost = Arrays.stream(costs).min()
            .orElseThrow(() -> new RuntimeException("비용 배열이 비어있습니다."));

        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            if (costs[i] != minCost) {
                sum += costs[i] * distances[i];
            } else {
                int remainedDistance = 0;
                for (int j = i; j < n - 1; j++) {
                    remainedDistance += distances[j];
                }

                int rest = remainedDistance * minCost;
                sum += rest;

                break;
            }
        }

        return sum;
    }
}