import java.util.Scanner;

class Expression {
    int x1;
    int y1;
    int result;

    public Expression(int x1, int y1, int result) {
        this.x1 = x1;
        this.y1 = y1;
        this.result = result;
    }

    public boolean isCorrect(int x, int y) {
        return calculate(x, y) == result;
    }

    private int calculate(int x, int y) {
        return x1 * x + y1 * y;
    }
}

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Expression e1 = new Expression(in.nextInt(), in.nextInt(), in.nextInt());
        Expression e2 = new Expression(in.nextInt(), in.nextInt(), in.nextInt());

        solution(e1, e2);
    }

    private static void solution(Expression e1, Expression e2) {
        int x = Integer.MIN_VALUE;
        int y = Integer.MIN_VALUE;

        for (int i = -999; i <= 999; i++) {
            if (x != Integer.MIN_VALUE && y != Integer.MIN_VALUE) {
                break;
            }

            for (int j = -999; j <= 999; j++) {
                if (e1.isCorrect(i, j) && e2.isCorrect(i, j)) {
                    x = i;
                    y = j;

                    break;
                }
            }
        }

        System.out.println(x + " " + y);
    }
}