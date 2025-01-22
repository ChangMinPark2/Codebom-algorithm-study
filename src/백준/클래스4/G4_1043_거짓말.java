package 백준.클래스4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G4_1043_거짓말 {
    static int n, m;
    static int[] parent;
    static List<List<Integer>> party = new ArrayList<>();
    static boolean[] knowTruth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");
        n = Integer.parseInt(repo[0]);
        m = Integer.parseInt(repo[1]);
        parent = new int[n + 1];

        String temp = br.readLine();
        repo = temp.split(" ");
        if (temp.equals("0")) {
            System.out.println(m);
            return;
        }

        int realCount = Integer.parseInt(repo[0]);
        int[] real = new int[realCount];
        for (int i = 1; i <= realCount; i++) {
            real[i - 1] = Integer.parseInt(repo[i]);
        }

        for (int i = 0; i < m; i++) {
            repo = br.readLine().split(" ");
            int partySize = Integer.parseInt(repo[0]);
            party.add(new ArrayList<>());

            for (int j = 1; j <= partySize; j++) {
                party.get(i).add(Integer.parseInt(repo[j]));
            }
        }

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (List<Integer> p : party) {
            for (int j = 0; j < p.size() - 1; j++) {
                union_node(p.get(j), p.get(j + 1));
            }
        }

        knowTruth = new boolean[n + 1];

        for (int t : real) {
            int root = find_parent(t);
            knowTruth[root] = true;
        }


        int answer = 0;

        for (List<Integer> p : party) {
            boolean flag = true;

            for (int person : p) {
                if (knowTruth[find_parent(person)]) {
                    flag = false;
                    break;
                }
            }
            if (flag) answer++;
        }

        System.out.println(answer);
    }

    public static int find_parent(int u) {
        if (parent[u] == u) return u;
        return parent[u] = find_parent(parent[u]);
    }

    public static void union_node(int u, int v) {
        u = find_parent(u);
        v = find_parent(v);
        if (u != v) parent[v] = u;
    }
}
