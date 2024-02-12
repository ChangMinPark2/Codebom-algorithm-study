package 백준.트리;

import java.io.*;
import java.util.*;

public class S5_나이순정렬 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Person> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.age == o2.age) {
                return o1.index - o2.index;
            }
            return o1.age - o2.age;
        });

        for (int i = 0; i < n; i++) {
            String[] repo = br.readLine().split(" ");
            int age = Integer.parseInt(repo[0]);
            String name = repo[1];

            pq.add(new Person(age, name, i));
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Person person = pq.remove();

            sb.append(person.age + " ").append(person.name + "\n");
        }

        System.out.println(sb.toString());
    }

    public static class Person {
        int age;
        String name;
        int index;

        public Person(int age, String name, int index) {
            this.age = age;
            this.name = name;
            this.index = index;
        }
    }
}
