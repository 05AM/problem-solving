import java.util.Arrays;
import java.util.Scanner;

class Main {

    static boolean[] primeNumbers;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        System.out.println(solution(nums));
    }

    private static int solution(int[] nums) {
        int max = Arrays.stream(nums)
                .max()
                .orElse(-1);

        primeNumbers = new boolean[max + 1];
        Arrays.fill(primeNumbers, true);
        primeNumbers[1] = false;

        for (int i = 2; i * i <= max; i++) {
            if (primeNumbers[i]) {
                for (int j = i * i; j <= max; j += i) {
                    primeNumbers[j] = false;
                }
            }
        }

        int answer = 0;
        for (int num : nums) {
            if (primeNumbers[num]) {
                answer++;
            }
        }

        return answer;
    }
}