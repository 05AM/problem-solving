import java.util.Scanner;

public class Main {
    public String solution(int length, String input) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < 7 * length; i += 7) {
            String code = input.substring(i, i + 7);
            int number = codeToNumber(code);
            answer.append(numberToAlphabet(number));
        }
        return answer.toString();
    }

    private int codeToNumber(String code) {
        String binaryString = code.replaceAll("#", "1").replaceAll("\\*", "0");
        return Integer.parseInt(binaryString, 2);
    }

    private char numberToAlphabet(int number) {
        return (char) number;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        String input = in.next();

        System.out.println(T.solution(length, input));
    }
}
