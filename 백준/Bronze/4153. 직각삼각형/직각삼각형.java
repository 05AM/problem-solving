import java.util.Arrays;
import java.util.Scanner;

public class Main {

	private final static int NUM_TRIANGLE_SIDE = 3;

	public static void main(String[] args) {
		Main main = new Main();
		Scanner in = new Scanner(System.in);

		int[] arr = new int[NUM_TRIANGLE_SIDE];

		while (true) {
			for (int i = 0; i < NUM_TRIANGLE_SIDE; i++) {
				arr[i] = in.nextInt();
			}

			if (arr[0] == 0) {
				break;
			}

			if (main.isRightTriangle(arr)) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
		}
	}

	private boolean isRightTriangle(int[] nums) {
		Arrays.sort(nums);

		return Math.pow(nums[2], 2) == (Math.pow(nums[0], 2) + Math.pow(nums[1], 2));
	}
}