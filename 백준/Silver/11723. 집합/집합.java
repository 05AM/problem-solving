import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        int set = 0B00000000000000000000;

        for (int i = 0; i < n; i++) {
            String[] input = in.readLine().split(" ");
            String command = input[0];
            int mask = input.length > 1 ? 1 << Integer.parseInt(input[1]) - 1 : 0;

            switch (command) {
                case "add":
                    set = set | mask;
                    break;
                case "remove":
                    set = set & ~mask;
                    break;
                case "check":
                    out.write(((set & mask) != 0 ? 1 : 0) + "\n");
                    break;
                case "toggle":
                    set = set ^ mask;
                    break;
                case "all":
                    set = (1 << 20) - 1;
                    break;
                case "empty":
                    set = 0;
            }
        }

        out.flush();
        out.close();
    }
}