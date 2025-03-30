import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        HashMap<String, String> accounts = new HashMap<>();

        for (int i = 0; i < n; i++) {
            accounts.put(in.next(), in.next());
        }

        for (int i = 0; i < m; i++) {
            String url = in.next();
            System.out.println(accounts.get(url));
        }

        in.close();
    }
}
