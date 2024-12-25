import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        int[] nums = Arrays.stream(in.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        ArrayList<Integer> sorted = Arrays.stream(nums)
            .sorted()
            .distinct()
            .boxed()
            .collect(Collectors.toCollection(ArrayList::new));

        HashMap<Integer, Integer> compressed = new HashMap<>();
        int rank = 0;
        for (Integer num : sorted) {
            compressed.put(num, rank++);
        }

        for (int num : nums) {
            out.write(compressed.get(num) + " ");
        }
        
        out.flush();
    }
}