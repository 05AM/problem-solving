import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int cnt = st.countTokens();

        System.out.println(cnt);
    }
}