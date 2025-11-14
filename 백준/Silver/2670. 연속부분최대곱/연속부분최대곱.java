import java.util.Scanner;

public class Main {
    // (지금까지의 곱) * (현재 값)이 현재 값보다 크면 계속 곱하고
    // 작으면 현재 값부터 시작

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        double[] nums = new double[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextDouble();
        }

        double max = nums[0];
        double result = nums[0];

        for (int i = 1; i < n; i++) {
            double num = nums[i];

            if (num * result > num) {
                result = num * result;
            } else {
                result = num;
            }
            max = Math.max(max, result);
        }

        // 반올림
        System.out.printf("%.3f\n", max);
    }
}