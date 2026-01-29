import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        Deque<Long> stack = new ArrayDeque<>();
        long answer = 0L;

        for (int i = 0; i < n; i++) {
            long height = Long.parseLong(in.readLine());

            while (!stack.isEmpty() && stack.peek() <= height) {
                stack.pop();
            }

            answer += stack.size();
            stack.push(height);
        }

        System.out.println(answer);
    }
}