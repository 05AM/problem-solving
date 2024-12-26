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

        int minX = houses[0];
        int maxX = houses[n - 1];

        int left = 1;
        int right = maxX - minX;

        int maxLength = 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(mid, c, houses)) {
                maxLength = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return maxLength;
    }

    private static boolean isPossible(int value, int count, int[] houses) {
        int currentInstalledX = houses[0];

        int installedCnt = 1;
        for (int i = 1; i < houses.length; i++) {
            if (houses[i] - currentInstalledX >= value) {
                installedCnt++;
                currentInstalledX = houses[i];
            }
        }

        return installedCnt >= count;
    }
}