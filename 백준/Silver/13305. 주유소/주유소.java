import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        long[] dists = new long[n - 1];
        long[] costs = new long[n];

        StringTokenizer input = new StringTokenizer(in.readLine());
        for (int i = 0; i < n - 1; i++) {
            dists[i] = Integer.parseInt(input.nextToken());
        }

        input = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            costs[i] = Integer.parseInt(input.nextToken());
        }

        long minTotal = solution(n, dists, costs);
        System.out.println(minTotal);
    }

    private static long solution(int n, long[] dists, long[] costs) {
        long sum = 0;
        long currentMinCost = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            if (costs[i] < currentMinCost) {
                currentMinCost = costs[i];
            }
            sum += currentMinCost * dists[i];
        }

        return sum;
    }
}
