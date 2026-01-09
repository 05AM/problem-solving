import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int bottleCnt = Integer.parseInt(st.nextToken());
        int cupCnt = Integer.parseInt(st.nextToken());

        int[] bottles = new int[bottleCnt];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < bottleCnt; i++) {
            bottles[i] = Integer.parseInt(in.readLine());
            max = Math.max(max, bottles[i]);
        }

        int answer = solution(max, bottleCnt, cupCnt, bottles);
        System.out.println(answer);
    }

    private static int solution(int max, int bottleCnt, int cupCnt, int[] bottles) {
        int left = 0;
        int right = max;
        int result = left;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isAvailable(mid, bottleCnt, cupCnt, bottles)) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private static boolean isAvailable(int amount, int bottleCnt, int cupCnt, int[] bottles) {
        if (amount == 0) {
            return true;
        }
        
        int possibleCnt = 0;
        for (int i = 0; i < bottleCnt; i++) {
            int curr = bottles[i];
            if (curr == 0) continue;
            
            possibleCnt += curr / amount;
        }

        return possibleCnt >= cupCnt;
    }
}