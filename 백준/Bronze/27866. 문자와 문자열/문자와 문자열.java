import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String word = in.next();
        int i = in.nextInt();

        System.out.println(word.charAt(i - 1));
    }
}
