import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] ranks = new int[n][3];

        for (int i = 0; i < n; i++) {
            int weight = in.nextInt();
            int height = in.nextInt();

            ranks[i][0] = weight;
            ranks[i][1] = height;
            ranks[i][2] = 1;

            for (int j = i - 1; j >= 0; j--) {
                if (weight > ranks[j][0] && height > ranks[j][1]) {
                    ranks[j][2]++;
                } else if (weight < ranks[j][0] && height < ranks[j][1]) {
                    ranks[i][2]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(ranks[i][2] + " ");
        }
    }
}