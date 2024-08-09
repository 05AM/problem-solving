import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();

            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            
            int[] triangle = new int[] {a, b, c};
            System.out.println(decideKindOfTriangle(triangle));
        }
    }

    public static String decideKindOfTriangle(int[] triangle) {
        Arrays.sort(triangle);
        int max = triangle[2];
        int sum = triangle[0] + triangle[1];

        if (sum <= max) {
            return "Invalid";
        }

        if (triangle[0] == triangle[1] && triangle[1] == triangle[2]) {
            return "Equilateral";
        } else if (triangle[0] != triangle[1] && triangle[1] != triangle[2] && triangle[2] != triangle[0]) {
            return "Scalene";
        } else {
            return "Isosceles";
        }
    }
}