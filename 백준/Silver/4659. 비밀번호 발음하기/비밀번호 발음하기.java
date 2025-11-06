import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final String ACCEPT_FORMAT = "<%s> is acceptable.";
    private static final String NOT_ACCEPT_FORMAT = "<%s> is not acceptable.";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String word;
        while (!(word = in.readLine()).equals("end")) {
            boolean isValid = true;
            char last = word.charAt(0);

            boolean hasVowel = isVowel(last);
            int currentVowelCnt = isVowel(last) ? 1 : 0;
            int currentConsonantCnt = isVowel(last) ? 0 : 1;

            for (int i = 1; i < word.length(); i++) {
                char curr = word.charAt(i);

                // 모음 있는지
                if (!hasVowel) {
                    hasVowel = isVowel(curr);
                }

                // 같은 글자 2번 연속
                if (curr == last) {
                    if (last != 'e' && last != 'o') {
                        isValid = false;
                        break;
                    }
                }

                // 모음 3개 / 자음 3개
                if (isVowel(last)) {
                    if (isVowel(curr)) {
                        currentVowelCnt++;
                    } else {
                        currentVowelCnt = 0;
                        currentConsonantCnt++;
                    }
                } else {
                    if (!isVowel(curr)) {
                        currentConsonantCnt++;
                    } else {
                        currentConsonantCnt = 0;
                        currentVowelCnt++;
                    }
                }
                
                if (currentVowelCnt == 3 || currentConsonantCnt == 3) {
                    isValid = false;
                    break;
                }

                last = curr;
            }

            isValid = isValid && hasVowel;
            System.out.println(isValid ? String.format(ACCEPT_FORMAT, word) : String.format(NOT_ACCEPT_FORMAT, word));
        }
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}