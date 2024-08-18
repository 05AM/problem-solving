import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        Queue<Integer> line = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            line.add(in.nextInt());
        }

        solution(line);
    }

    private static void solution(Queue<Integer> line) {
        Stack<Integer> subLine = new Stack<>();
        boolean isPossible = true;
        int seq = 1; // 현재 번호표 순서

        while (!line.isEmpty() || !subLine.isEmpty()) {
            if (!subLine.isEmpty() && subLine.peek() == seq) {
                subLine.pop();
                seq++;
            } else if (!line.isEmpty() && line.peek() == seq) {
                line.poll();
                seq++;
            } else if (!line.isEmpty()) {
                subLine.push(line.poll());
            } else {
                isPossible = false;
                break;
            }
        }

        String answer = isPossible ? "Nice" : "Sad";
        System.out.println(answer);
    }
}
