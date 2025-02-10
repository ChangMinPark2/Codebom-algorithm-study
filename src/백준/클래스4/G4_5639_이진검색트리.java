package 백준.클래스4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G4_5639_이진검색트리 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));

        while (true) {
            String input = br.readLine();

            if (input == null || input.equals("")) break;
            root.insert(Integer.parseInt(input));
        }

        postOrder(root);
        System.out.println(sb);
    }

    public static class Node {
        int number;
        Node left;
        Node right;

        public Node(int number) {
            this.number = number;
        }

        public Node(int number, Node left, Node right) {
            this.number = number;
            this.left = left;
            this.right = right;
        }

        void insert(int n) {
            if (n < this.number) {
                if (this.left == null) {
                    this.left = new Node(n);
                } else {
                    this.left.insert(n);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(n);
                } else {
                    this.right.insert(n);
                }
            }
        }
    }

    static void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.number).append("\n");
    }
}
