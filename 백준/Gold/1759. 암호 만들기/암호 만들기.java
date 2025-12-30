import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    static int l, c;
    static char[] alphabets;
    static char[] selected;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        selected = new char[l];
        alphabets = in.readLine().replaceAll(" ", "").toCharArray();
        Arrays.sort(alphabets);

        findAllPossiblePassword(0, 0, 0, 0);

        System.out.println(result);
    }

    private static void findAllPossiblePassword(int selectIdx, int startIdx, int consonantCnt, int vowelCnt) {
        if (selectIdx == selected.length) {
            if (consonantCnt >= 2 && vowelCnt >= 1) {
                for (int i = 0; i < l; i++) {
                    result.append(selected[i]);
                }
                result.append("\n");
            }
        } else {
            for (int i = startIdx; i < c; i++) {
                if (c - i < l - selectIdx) {
                    break;
                }

                char ch = alphabets[i];
                selected[selectIdx] = ch;

                int nextConsonantCnt = !isVowel(ch) ? consonantCnt + 1 : consonantCnt;
                int nextVowelCnt = isVowel(ch) ? vowelCnt + 1 : vowelCnt;

                findAllPossiblePassword(selectIdx + 1, i + 1, nextConsonantCnt, nextVowelCnt);
            }
        }
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
