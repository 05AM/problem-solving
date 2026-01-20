import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        String str = in.readLine();

        int result = solution(n, str);
        System.out.println(result);
    }

    private static int solution(int n, String str) {
        int[] cnt = new int[26];

        int answer = 0;
        int total = 0;
        for (int l = 0, r = -1; l < str.length(); l++) {
            // 종류가 n개인 최대 r까지 반복
            while (r + 1 < str.length() && total <= n) {
                int idx = str.charAt(r + 1) - 'a';

                if (total == n && cnt[idx] == 0) {
                    break;
                }

                r++;
                cnt[idx]++;

                // 새로운 종류가 등록되면
                if (cnt[idx] == 1) {
                    total++;
                }
            }

            // 최대 r을 구하면 정답 갱신
            answer = Math.max(answer, r - l + 1);

            int idx = str.charAt(l) - 'a';
            cnt[idx]--;
            if (cnt[idx] == 0) {
                total--;
            }
        }

        return answer;
    }
}
