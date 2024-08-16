import java.util.Scanner;

class Main {
    private static int count = 0;
    private static int k;
    private static int result = -1;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        k = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        mergeSort(a, 0, a.length - 1);
        System.out.println(result);
    }

    private static void mergeSort(int[] a, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(a, p, q);
            mergeSort(a, q + 1, r);
            merge(a, p, q, r);
        }
    }

    private static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int t = 0;

        int[] tmp = new int[r - p + 1];

        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[t++] = a[i++];
            } else {
                tmp[t++] = a[j++];
            }
            count++;
            if (count == k) {
                result = tmp[t - 1];
            }
        }

        while (i <= q) {
            tmp[t++] = a[i++];
            count++;
            if (count == k) {
                result = tmp[t - 1];
            }
        }

        while (j <= r) {
            tmp[t++] = a[j++];
            count++;
            if (count == k) {
                result = tmp[t - 1];
            }
        }

        for (t = 0; t < tmp.length; t++) {
            a[p + t] = tmp[t];
        }
    }
}
