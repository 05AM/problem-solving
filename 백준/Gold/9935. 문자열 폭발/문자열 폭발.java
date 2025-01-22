import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String originalString = in.next();
        String explosionString = in.next();
        char lastExplosionChar = explosionString.charAt(explosionString.length() - 1);
        int explosionLength = explosionString.length();

        StringBuilder sb = new StringBuilder();

        for (char ch : originalString.toCharArray()) {
            sb.append(ch);

            if (ch == lastExplosionChar && sb.length() >= explosionLength) {
                String targetString = sb.substring(sb.length() - explosionLength, sb.length());

                if (explosionString.equals(targetString)) {
                    sb.delete(sb.length() - explosionLength, sb.length());
                }
            }
        }

        if (sb.toString().isEmpty()) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }
    }
}
