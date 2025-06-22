import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        while (T-- > 0) {
            TreeMap<Integer, Integer> dualPriorityQueue = new TreeMap<>();
            int k = in.nextInt();

            boolean isEmpty = false;

            while (k-- > 0) {
                String command = in.next();
                int operand = Integer.parseInt(in.next());

                switch (command) {
                    case "I":
                        dualPriorityQueue.merge(operand, 1, Integer::sum);
                        break;
                    case "D":
                        if (dualPriorityQueue.isEmpty()) {
                            isEmpty = true;
                            continue;
                        }

                        Map.Entry<Integer, Integer> entry;
                        if (operand == 1) {
                            entry = dualPriorityQueue.lastEntry();
                        } else {
                            entry = dualPriorityQueue.firstEntry();
                        }

                        if (entry.getValue() > 1) {
                            dualPriorityQueue.put(entry.getKey(), entry.getValue() - 1);
                        } else {
                            dualPriorityQueue.remove(entry.getKey());
                        }
                        break;
                }
            }

            if (dualPriorityQueue.isEmpty()) {
                System.out.println("EMPTY");
                continue;
            }

            int max = dualPriorityQueue.lastKey();
            int min = dualPriorityQueue.firstKey();

            System.out.println(max + " " + min);
        }
    }
}