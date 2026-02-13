import java.io.*;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());

        int W = Integer.parseInt(st.nextToken());

        int[] a = new int[W];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < W; i++) a[i] = Integer.parseInt(st.nextToken());

        int[] leftMax = new int[W];

        int[] rightMax = new int[W];

        leftMax[0] = a[0];
        for (int i = 1; i < W; i++) leftMax[i] = Math.max(leftMax[i - 1], a[i]);

        rightMax[W - 1] = a[W - 1];

        for (int i = W - 2; i >= 0; i--) rightMax[i] = Math.max(rightMax[i + 1], a[i]);

        long ans = 0;

        for (int i = 0; i < W; i++) {

            int ceiling = Math.min(leftMax[i], rightMax[i]);

            if (ceiling > a[i]) ans += (ceiling - a[i]);

        }

        System.out.println(ans);

    }

}