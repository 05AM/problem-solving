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
