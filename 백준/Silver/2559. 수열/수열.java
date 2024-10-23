import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        int[] temperatures = new int[n];

        for (int i = 0; i < n; i++) {
            temperatures[i] = in.nextInt();
        }

        System.out.println(solution(n, k, temperatures));
    }

    private static int solution(int n, int k, int[] temperatures) {
        int currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += temperatures[i];
        }

        int max = currentSum;
        for (int i = k; i < n; i++) {
            currentSum = currentSum - temperatures[i - k] + temperatures[i];
            max = Math.max(max, currentSum);
        }

        return max;
    }
}