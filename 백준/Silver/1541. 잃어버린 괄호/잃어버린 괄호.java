import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();
        int[] nums = Arrays.stream(input.split("(?=[-+])"))
            .mapToInt(Integer::parseInt)
            .toArray();

        solution(nums);
    }

    private static void solution(int[] nums) {
        int result = 0;
        int sum = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] >= 0) {
                sum += nums[i];
            } else {
                result += -(Math.abs(nums[i]) + sum);
                sum = 0;
            }

            if (i == 0) {
                result = sum + result;
            }
        }

        System.out.println(result);
    }
}