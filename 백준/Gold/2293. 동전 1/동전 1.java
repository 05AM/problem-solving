// bottom up 방식
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int coinCount = Integer.parseInt(st.nextToken());
        int targetAmount = Integer.parseInt(st.nextToken());

        int[] coins = new int[coinCount];
        for (int i = 0; i < coinCount; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] ways = new int[targetAmount + 1];
        ways[0] = 1;

        for (int coin : coins) {
            for (int amount = coin; amount <= targetAmount; amount++) {
                ways[amount] += ways[amount - coin];
            }
        }

        System.out.println(ways[targetAmount]);
    }
}

// top down 방식
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] coins;
    static int[][] memo;
    static int coinCount, targetAmount;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        coinCount = Integer.parseInt(st.nextToken());
        targetAmount = Integer.parseInt(st.nextToken());

        coins = new int[coinCount + 1];
        for (int i = 1; i <= coinCount; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        memo = new int[coinCount + 1][targetAmount + 1];
        for (int i = 0; i <= coinCount; i++) {
            Arrays.fill(memo[i], -1);
        }


        solution(coinCount, targetAmount);
        System.out.println(memo[coinCount][targetAmount]);
    }

    private static int solution(int i, int sum) {
        if (sum == 0) {
            return 1;
        }

        if (i == 0) {
            return 0;
        }

        if (sum < 0) {
            return 0;
        }

        if (memo[i][sum] != -1) {
            return memo[i][sum];
        }

        memo[i][sum] = solution(i - 1, sum) + solution(i, sum - coins[i]);
        return memo[i][sum];
    }
}
