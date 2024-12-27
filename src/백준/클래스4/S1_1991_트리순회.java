package 백준.클래스4;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * N <= 26 (완탐), 백트래킹
 */
public class S1_1991_트리순회 {
    static int n;
    static Tree[] trees;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        trees = new Tree[n + 1];

        for (int i = 0; i < n; i++) {
            String[] repo = br.readLine().split(" ");
            char name = repo[0].charAt(0);
            char left = repo[1].charAt(0);
            char right = repo[2].charAt(0);

            if (trees[name - 'A'] == null) {
                trees[name - 'A'] = new Tree(name);
            }
            if (left != '.') {
                trees[left - 'A'] = new Tree(left);
                trees[name - 'A'].left = trees[left - 'A'];
            }
            if (right != '.') {
                trees[right - 'A'] = new Tree(right);
                trees[name - 'A'].right = trees[right - 'A'];
            }
        }

        preorder(trees[0]);
        sb.append("\n");
        inorder(trees[0]);
        sb.append("\n");
        postorder(trees[0]);

        System.out.println(sb);
    }

    //전위
    private static void preorder(Tree tree) {
        if (tree == null) return;
        sb.append(tree.name);
        preorder(tree.left);
        preorder(tree.right);
    }

    //중위
    private static void inorder(Tree tree) {
        if (tree == null) return;
        inorder(tree.left);
        sb.append(tree.name);
        inorder(tree.right);
    }

    //후위
    private static void postorder(Tree tree) {
        if (tree == null) return;
        postorder(tree.left);
        postorder(tree.right);
        sb.append(tree.name);
    }


    private static class Tree {
        char name;
        Tree left;
        Tree right;

        public Tree(char name) {
            this.name = name;
            this.left = null;
            this.right = null;
        }
    }
}
