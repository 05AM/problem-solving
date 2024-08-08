import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        Map<Integer, String> collectionIdToName = new HashMap<>();
        Map<String, Integer> collectionNameToId = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String name = in.next();

            collectionIdToName.put(i, name);
            collectionNameToId.put(name, i);
        }

        for (int i = 0; i < m; i++) {
            String input = in.next();

            if (Character.isDigit(input.charAt(0))) {
                System.out.println(collectionIdToName.get(Integer.parseInt(input)));
            } else {
                System.out.println(collectionNameToId.get(input));
            }
        }
    }
}