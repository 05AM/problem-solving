import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        int current = 1;
        boolean possible = true;

        for (int i = 0; i < n; i++) {
            int target = in.nextInt();

            while (current <= target) {
                stack.push(current++);
                result.append("+\n");
            }

            if (stack.peek() == target) {
                stack.pop();
                result.append("-\n");
            } else {
                possible = false;
                break;
            }
        }

        if (possible) {
            System.out.print(result);
        } else {
            System.out.println("NO");
        }
    }
}
