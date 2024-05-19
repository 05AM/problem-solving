import java.util.Scanner;

public class Main {

	private int solution(int[] nums) {
		int cnt = 0;

		for (int n : nums) {
			if (isPrimeNumber(n)) {
				cnt++;
			}
		}

		return cnt;
	}

	private boolean isPrimeNumber(int num) {
		if (num == 1) {
			return false;
		}

		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Main main = new Main();
		Scanner in = new Scanner(System.in);

		int size = in.nextInt();
		int[] arr = new int[size];

		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}

		System.out.println(main.solution(arr));
	}
}