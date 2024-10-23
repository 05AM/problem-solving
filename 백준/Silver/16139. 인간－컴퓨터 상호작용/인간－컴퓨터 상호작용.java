import java.util.Scanner;

public class Main {
    static int[][] prefixSum;
    static final int ALPHABETS_CNT = 26;
    static final char LOW_A = 'a';

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        prefixSum = new int[ALPHABETS_CNT][s.length() + 1];
        solution(s);

        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            char alpha = in.next().charAt(0);
            int l = in.nextInt();
            int r = in.nextInt();

            int index = alpha - LOW_A;
            System.out.println(prefixSum[index][r + 1] - prefixSum[index][l]);
        }

    }

    private static void solution(String s) {
        for (int i = 0; i < ALPHABETS_CNT; i++) {
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == (LOW_A + i)) {
                    prefixSum[i][j + 1] = prefixSum[i][j] + 1;
                } else {
                    prefixSum[i][j + 1] = prefixSum[i][j];
                }
            }
        }
    }
}