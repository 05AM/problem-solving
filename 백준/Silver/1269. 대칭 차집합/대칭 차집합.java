import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        Set<Integer> a = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            a.add(in.nextInt());
        }

        Set<Integer> b = new TreeSet<>();
        for (int i = 0; i < m; i++) {
            int input = in.nextInt();

            if (a.contains(input)) {
                a.remove(input);
            } else {
                b.add(input);
            }
        }

        System.out.println(a.size() + b.size());
    }
}