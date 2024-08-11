import java.util.Scanner;

class Main {
    private static int[] memory;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        memory = new int[n + 1];

        System.out.println(solution(n));
    }

    public static int solution(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        
        if (memory[n] == 0) {
            memory[n] = solution(n - 1) + solution(n - 2);
        }
        
        return memory[n];
    }
}