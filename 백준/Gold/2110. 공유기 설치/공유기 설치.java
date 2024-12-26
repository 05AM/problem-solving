import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(in.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int n = input[0];
        int c = input[1];

        int[] houses = new int[n];
        for (int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(in.readLine());
        }

        int result = solution(n, c, houses);
        System.out.println(result);
    }

    private static int solution(int n, int c, int[] houses) {
        Arrays.sort(houses);

        int left = 1;
        int right = houses[n - 1] - houses[0];
        int maxLength = 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canInstallAll(mid, c, houses)) {
                maxLength = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return maxLength;
    }

    private static boolean canInstallAll(int distance, int targetCount, int[] houses) {
        int installedCount = 1;
        int lastInstalled = houses[0];

        for (int i = 1; i < houses.length; i++) {
            if (houses[i] - lastInstalled >= distance) {
                installedCount++;
                lastInstalled = houses[i];
            }
        }

        return installedCount >= targetCount;
    }
}