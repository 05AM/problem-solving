import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    static class Dot implements Comparable<Dot> {
        int location;
        int color;

        public Dot(int location, int color) {
            this.location = location;
            this.color = color;
        }

        @Override
        public int compareTo(Dot o) {
            if (color != o.color) {
                return color - o.color;
            }

            return location - o.location;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        Dot[] dots = new Dot[n];
        for (int i = 0; i < n; i++) {
            dots[i] = new Dot(in.nextInt(), in.nextInt());
        }

        Arrays.sort(dots);

        int answer = 0;
        for (int i = 1; i < n - 1; i++) {
            int color = dots[i].color;
            int location = dots[i].location;

            int min = Integer.MAX_VALUE;
            if (color == dots[i - 1].color) {
                min = Math.min(min, location - dots[i - 1].location);
            }

            if (color == dots[i + 1].color) {
                min = Math.min(min, dots[i + 1].location - location);
            }

            answer += min;
        }

        // 시작, 끝 값 더하기
        answer += dots[1].location - dots[0].location;
        answer += dots[n - 1].location - dots[n - 2].location;

        System.out.println(answer);
    }
}
