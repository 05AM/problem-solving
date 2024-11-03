import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] input = in.readLine().split(" ");
            int result;

            switch (input[0]) {
                case "push":
                    queue.offer(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    result = queue.isEmpty() ? -1 : queue.poll();
                    out.write(result + "\n");
                    break;
                case "size":
                    out.write(queue.size() + "\n");
                    break;
                case "empty":
                    result = queue.isEmpty() ? 1 : 0;
                    out.write(result + "\n");
                    break;
                case "front":
                    result = queue.isEmpty() ? -1 : queue.peek();
                    out.write(result + "\n");
                    break;
                case "back":
                    result = queue.isEmpty() ? -1 : queue.getLast();
                    out.write(result + "\n");
                    break;
                default:
                    throw new RuntimeException("알 수 없는 명령어 입니다.");
            }
        }

        out.flush();
        out.close();
        in.close();
    }
}