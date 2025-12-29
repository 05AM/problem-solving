import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Element implements Comparable<Element> {
        int num;
        int initIndex;

        public Element(int num, int initIndex) {
            this.num = num;
            this.initIndex = initIndex;
        }

        @Override
        public int compareTo(Element o) {
            if (num != o.num) {
                return num - o.num;
            }

            return initIndex - o.initIndex;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());

        Element[] a = new Element[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Element(Integer.parseInt(st.nextToken()), i);
        }

        Arrays.sort(a);

        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            Element element = a[i];
            p[element.initIndex] = i;
        }

        StringBuilder result = new StringBuilder();
        for (int i : p) {
            result.append(i).append(" ");
        }

        System.out.println(result);
    }
}