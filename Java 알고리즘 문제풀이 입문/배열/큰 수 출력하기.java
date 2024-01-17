import java.util.Scanner;

public class Main {
    public void solution(int n, int[] numbers) {
        System.out.print(numbers[0]);

        for (int i = 1; i < n; i++) {
            if (numbers[i] > numbers[i - 1]) {
                System.out.print(" " + numbers[i]);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = in.nextInt();
        }
        
        T.solution(n, numbers);
    }
}
