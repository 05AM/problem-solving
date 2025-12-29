import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextLong();
        }

        Arrays.sort(nums);

        long mode = nums[0];
        long modeCnt = 1, currCnt = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                currCnt++;
            } else {
                currCnt = 1;
            }

            if (currCnt > modeCnt) {
                modeCnt = currCnt;
                mode = nums[i];
            }
        }

        System.out.println(mode);
    }
}
