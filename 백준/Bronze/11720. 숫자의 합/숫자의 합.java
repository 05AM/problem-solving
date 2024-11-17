import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        String input = in.next();
        int sum = 0;
        for (char ch : input.toCharArray()) {
            sum += Character.getNumericValue(ch);
        }

        System.out.println(sum);
    }
}