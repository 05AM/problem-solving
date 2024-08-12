import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(in.readLine());

            if (value != 0) {
                stack.push(value);
            } else {
                stack.pop();
            }
        }

        int sum = stack.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(sum);
    }
}