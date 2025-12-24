import java.util.*;

public class Main {

    static int n;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int[] sequence, operators;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        sequence = new int[n];
        operators = new int[4];

        for (int i = 0; i < n; i++) {
            sequence[i] = in.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            operators[i] = in.nextInt();
        }

        calculateAll(1, sequence[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void calculateAll(int i, int value) {
        if (i == n) {
            min = Math.min(min, value);
            max = Math.max(max, value);
        } else {
            for (int j = 0; j < 4; j++) {
                if (operators[j] != 0) {
                    int newValue = calculate(value, j, sequence[i]);

                    operators[j]--;
                    calculateAll(i + 1, newValue);
                    operators[j]++;
                }
            }
        }
    }

    private static int calculate(int op1, int operator, int op2) {
        switch (operator) {
            case 0:
                return op1 + op2;
            case 1:
                return op1 - op2;
            case 2:
                return op1 * op2;
            default:
                return op1 / op2;
        }
    }
}
