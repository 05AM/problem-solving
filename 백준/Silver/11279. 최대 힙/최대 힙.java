import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();

            if (x != 0) {
                pq.offer(x);
            } else {
                int value = pq.isEmpty() ? 0 : pq.poll();
                System.out.println(value);
            }
        }

        in.close();
    }
}