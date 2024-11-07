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
        int sum = 0;
        int currentMinCost = Integer.MAX_VALUE;

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