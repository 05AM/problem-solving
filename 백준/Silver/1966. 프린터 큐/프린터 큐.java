import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        while(T-- > 0) {
            int n = in.nextInt();
            int target = in.nextInt();

            Queue<int[]> q = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            for (int j = 0, order = 0; j < n; j++) {
                int importance = in.nextInt();
                q.add(new int[] {order++, importance});
                pq.add(importance);
            }

            int printOrder = 1;
            while (!q.isEmpty()) {
                int[] document = q.poll();

                if (document[1] == pq.peek()) {
                    if (document[0] == target) {
                        System.out.println(printOrder);
                        break;
                    }
                    pq.poll();
                    printOrder++;
                } else {
                    q.add(document);
                }
            }
        }

        in.close();
    }
}