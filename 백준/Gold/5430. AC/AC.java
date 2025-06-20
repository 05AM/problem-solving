import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        while (n-- > 0) {
            String commands = in.next();
            int size = in.nextInt();

            String input = in.next();
            Deque<Integer> nums = input.equals("[]")
                    ? new LinkedList<>()
                    : Arrays.stream(input.substring(1, input.length() - 1).split(","))
                            .map(Integer::parseInt)
                            .collect(Collectors.toCollection(LinkedList::new));

            boolean isNaturalOrder = true;
            boolean isError = false;

            for (char command : commands.toCharArray()) {
                switch (command) {
                    case 'R':
                        isNaturalOrder = !isNaturalOrder;
                        break;
                    case 'D':
                        if (nums.isEmpty()) {
                            isError = true;
                        } else {
                            if (isNaturalOrder) {
                                nums.removeFirst();
                            } else {
                                nums.removeLast();
                            }
                        }
                        break;
                }

                if (isError) {
                    break;
                }
            }

            StringBuilder result = new StringBuilder();
            if (isError) {
                result.append("error");
            } else {
                result.append("[");

                Iterator<Integer> it = isNaturalOrder ? nums.iterator() : nums.descendingIterator();
                while (it.hasNext()) {
                    result.append(it.next());
                    if(it.hasNext()) result.append(",");
                }

                result.append("]");
            }

            System.out.println(result);
        }
    }
}