import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int weightN = in.nextInt();
        int[] weights = new int[weightN];
        int maxWeight = 0;
        for (int i = 0; i < weightN; i++) {
            weights[i] = in.nextInt();
            maxWeight += weights[i];
        }

        boolean[] dp = new boolean[maxWeight + 1];
        dp[0] = true;

        for (int weight : weights) {
            boolean[] nextDp = dp.clone();

            for (int w = 0; w <= maxWeight; w++) {
                if (dp[w]) {
                    // 추를 구슬 반대쪽에 추가
                    if (w + weight <= maxWeight) {
                        nextDp[w + weight] = true;
                    }

                    // 현재 추 단독으로 구슬 반대쪽에 추가
                    if (weight - w >= 0) {
                        nextDp[weight - w] = true;
                    }

                    // 현재 추를 구슬쪽에
                    if (w - weight >= 0) {
                        nextDp[w - weight] = true;
                    }
                }
            }

            dp = nextDp;
        }
        
        int beadN = in.nextInt();
        for (int i = 1; i <= beadN; i++) {
            int beadWeight = in.nextInt();
            
            char result = beadWeight <= maxWeight && dp[beadWeight] ? 'Y' : 'N';
            System.out.print(result + " ");
        }
    }
}