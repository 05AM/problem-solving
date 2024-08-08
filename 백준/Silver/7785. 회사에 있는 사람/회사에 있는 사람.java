import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Main {

    private static final String ENTER = "enter";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        TreeMap<String, String> log = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = in.next();
            String status = in.next();

            log.put(name, status);
        }

        for (Map.Entry<String, String> entry : log.descendingMap().entrySet()) {
            if (ENTER.equals(entry.getValue())) {
                System.out.println(entry.getKey());
            }
        }
    }
}