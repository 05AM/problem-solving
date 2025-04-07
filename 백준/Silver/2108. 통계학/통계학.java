import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        List<Integer> nums = new ArrayList<>();
        Map<Integer, Integer> appearCnt = new HashMap<>();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            nums.add(num);
            appearCnt.merge(num, 1, Integer::sum);
            sum += num;
        }

        Collections.sort(nums);
        int size = nums.size();
        List<Map.Entry<Integer, Integer>> sortedEntries = appearCnt.entrySet()
                .stream()
                .sorted(Comparator
                        .<Map.Entry<Integer, Integer>>comparingInt(Map.Entry::getValue)
                        .reversed()
                        .thenComparing(Map.Entry.<Integer, Integer>comparingByKey())
                )
                .collect(Collectors.toList());

        long avg = Math.round((double)sum / size);
        int mid = nums.get(size / 2);
        int range = nums.get(size - 1) - nums.get(0);

        int mode;
        if (size != 1 && sortedEntries.get(0).getValue() == sortedEntries.get(1).getValue()) {
            mode = sortedEntries.get(1).getKey();
        } else {
            mode = sortedEntries.get(0).getKey();
        }

        System.out.println(avg);
        System.out.println(mid);
        System.out.println(mode);
        System.out.println(range);
    }
}