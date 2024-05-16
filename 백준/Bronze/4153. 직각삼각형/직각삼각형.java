import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private boolean isRightTriangle(int[] nums) {
		Arrays.sort(nums);

		return Math.pow(nums[2], 2) == (Math.pow(nums[0], 2) + Math.pow(nums[1], 2));
	}

	public static void main(String[] args) {
		Main main = new Main();
		Scanner in = new Scanner(System.in);

		int size = 3;
		int[] arr = new int[size];

		while (true) {
			for (int i = 0; i < size; i++) {
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
}