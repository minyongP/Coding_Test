package datastructure.queue;

import java.util.*;

public class P28107 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Set<Integer>> orders = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int k = sc.nextInt();
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < k; j++) {
                set.add(sc.nextInt());
            }
            orders.add(set);
        }

        int[] eaten = new int[N];
        Set<Integer>[] already = new HashSet[N];
        for (int i = 0; i < N; i++) {
            already[i] = new HashSet<>();
        }

        for (int i = 0; i < M; i++) {
            int sushi = sc.nextInt();

            for (int person = 0; person < N; person++) {
                if (orders.get(person).contains(sushi) && !already[person].contains(sushi)) {
                    eaten[person]++;
                    already[person].add(sushi);
                    break;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(eaten[i] + " ");
        }
    }
}
