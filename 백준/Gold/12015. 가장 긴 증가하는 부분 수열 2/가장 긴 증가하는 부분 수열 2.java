import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[] a = Arrays.stream(in.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int result = getLISLength(n, a);
        System.out.println(result);
    }

    private static int getLISLength(int n, int[] a) {
        List<Integer> dp = new ArrayList<>();
        dp.add(a[0]);

        for (int num : a) {
            int left = 0;
            int right = dp.size() - 1;

            int index = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (dp.get(mid) >= num) {
                    index = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if (index == -1) {
                dp.add(num);
            } else {
                dp.set(index, num);
            }
        }
        return dp.size();
    }
}