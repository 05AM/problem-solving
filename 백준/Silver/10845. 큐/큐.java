import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String command = in.next();

            switch (command) {
                case "push":
                    queue.offer(in.nextInt());
                    break;
                case "pop":
                    System.out.println(queue.isEmpty() ? -1 : queue.pop());
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    System.out.println(queue.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    System.out.println(queue.isEmpty() ? -1 : queue.getFirst());
                    break;
                case "back":
                    System.out.println(queue.isEmpty() ? -1 : queue.getLast());
                    break;
            }
        }
    }
}