import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        PriorityQueue<Integer> majorQueue = new PriorityQueue<>();
        PriorityQueue<Integer> minorQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            if (num == 0) {
                int n1 = !majorQueue.isEmpty() ? majorQueue.peek() : 0;
                int n2 = !minorQueue.isEmpty() ? minorQueue.peek() : 0;

                if (n1 == 0 || n2 == 0) {
                    if (n1 == n2) {
                        System.out.println(0);
                    } else if (n1 != 0) {
                        System.out.println(majorQueue.poll());
                    } else {
                        System.out.println(minorQueue.poll());
                    }
                } else {
                    int n1Abs = Math.abs(n1);
                    int n2Abs = Math.abs(n2);

                    if (n1Abs == n2Abs) {
                        System.out.println(minorQueue.poll());
                    } else {
                        if (n1Abs < n2Abs) {
                            System.out.println(majorQueue.poll());
                        } else {
                            System.out.println(minorQueue.poll());
                        }
                    }
                }
            } else {
                if (num > 0) {
                    majorQueue.add(num);
                } else {
                    minorQueue.add(num);
                }
            }
        }
    }
}