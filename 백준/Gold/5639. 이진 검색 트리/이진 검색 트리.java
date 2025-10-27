import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> preorder = new ArrayList<>();

        String input = null;
        while ((input = in.readLine()) != null) {
            preorder.add(Integer.parseInt(input.trim()));
        }

        Node root = buildBinarySearchTree(preorder);
        postorder(root);
    }

    private static Node buildBinarySearchTree(List<Integer> preorder) {
        Node root = new Node(preorder.get(0));
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        for (int i = 1; i < preorder.size(); i++) {
            int value = preorder.get(i);
            Node curr = new Node(value);

            if (value < stack.peek().value) {
                stack.peek().left = curr;
                stack.push(curr);
            } else {
                Node parent = null;
                while (!stack.isEmpty() && stack.peek().value < value) {
                    parent = stack.pop();
                }
                parent.right = curr;
                stack.push(curr);
            }
        }

        return root;
    }

    private static void postorder(Node node) {
        if (node.left != null) {
            postorder(node.left);
        }

        if (node.right != null) {
            postorder(node.right);
        }

        System.out.println(node.value);
    }
}
