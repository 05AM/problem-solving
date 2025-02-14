import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static final int MAX_N_CNT = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] input = in.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int[] nums = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int minLength = solution(s, nums);
        System.out.println(minLength);

        in.close();
    }

    private static int solution(int s, int[] nums) {
        int front = 0;
        int back = 0;

        int minLength = MAX_N_CNT;
        int currentSum = nums[0];

        while (front <= back && back < nums.length) {
            if (currentSum >= s) {
                minLength = Math.min(minLength, back - front + 1);
                currentSum -= nums[front];
                front++;
            } else {
                back++;
                if (back < nums.length) {
                    currentSum += nums[back];
                }
            }
        }

        return minLength != MAX_N_CNT ? minLength : 0;
    }
}