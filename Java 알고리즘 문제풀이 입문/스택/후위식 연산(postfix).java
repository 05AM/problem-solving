import java.util.Scanner;
import java.util.Stack;

public class Main {
    private int solution(String s) {
        Stack<Integer> operands = new Stack<>();

        for (char op : s.toCharArray()) {
            if (Character.isDigit(op)) {
                operands.add(Character.getNumericValue(op));
            } else {
                int lt = operands.pop();
                int rt = operands.pop();

                switch (op) {
                    case '+':
                        operands.add(rt + lt);
                        break;
                    case '-':
                        operands.add(rt - lt);
                        break;
                    case '*':
                        operands.add(rt * lt);
                        break;
                    case '/':
                        operands.add(rt / lt);
                        break;
                }
            }
        }
        return operands.pop();
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        String s = in.next();

        System.out.println(T.solution(s));
    }
}
