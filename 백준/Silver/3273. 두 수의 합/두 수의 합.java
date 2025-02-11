import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[] nums = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int x = Integer.parseInt(in.readLine());

        System.out.println(solution(nums, x));

        in.close();
    }

    private static int solution(int[] nums, int x) {
        Arrays.sort(nums);
        int cnt = 0;

        int front = 0;
        int back = nums.length - 1;

        while (front < back) {
            int sum = nums[front] + nums[back];

            if (sum == x) {
                cnt++;
                front++;
                back--;
            } else if (sum < x) {
                front++;
            } else if (sum > x) {
                back--;
            }
        }

        return cnt;
    }
}