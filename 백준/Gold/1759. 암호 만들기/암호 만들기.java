import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    static int l, c;
    static String[] alphabets;
    static String[] selected;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        selected = new String[l];
        alphabets = in.readLine().split(" ");
        Arrays.sort(alphabets);

        findAllPossiblePassword(0, 0, 0, 0, 0);

        System.out.println(result);
    }

    private static void findAllPossiblePassword(int level, int selectIdx, int startIdx, int consonantCnt, int vowelCnt) {
        if (level == l) {
            if (selectIdx == selected.length && consonantCnt >= 2 && vowelCnt >= 1) {
                result.append(String.join("", selected)).append("\n");
            }
        } else {
            for (int i = startIdx; i < c; i++) {
                selected[selectIdx] = alphabets[i];

                int nextConsonantCnt = consonantCnt;
                int nextVowelCnt = vowelCnt;
                if (isVowel(alphabets[i])) {
                    nextVowelCnt++;
                } else {
                    nextConsonantCnt++;
                }

                findAllPossiblePassword(level + 1, selectIdx + 1, i + 1, nextConsonantCnt, nextVowelCnt);
                findAllPossiblePassword(level + 1, selectIdx, i + 1, consonantCnt, vowelCnt);
            }
        }
    }

    private static boolean isVowel(String ch) {
        return Objects.equals(ch, "a") || Objects.equals(ch, "e") || Objects.equals(ch, "i") || Objects.equals(ch, "o")
                || Objects.equals(ch, "u");
    }
}
