package 백준.클래스4.re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_1991_RE {
    static int n;
    static Tree[] trees;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        trees = new Tree[n];

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            char name = temp[0].charAt(0);
            char left = temp[1].charAt(0);
            char right = temp[2].charAt(0);

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

        before(trees[0]);
        sb.append("\n");
        inOrder(trees[0]);
        sb.append("\n");
        after(trees[0]);

        System.out.println(sb);
    }

    private static void before(Tree tree) {
        if (tree == null) return;
        sb.append(tree.name);
        before(tree.left);
        before(tree.right);
    }

    private static void inOrder(Tree tree) {
        if (tree == null) return;
        inOrder(tree.left);
        sb.append(tree.name);
        inOrder(tree.right);
    }

    private static void after(Tree tree) {
        if (tree == null) return;
        after(tree.left);
        after(tree.right);
        sb.append(tree.name);
    }

    public static class Tree {
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
