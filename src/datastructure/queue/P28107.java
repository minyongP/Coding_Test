package datastructure.queue;

import java.util.*;

public class P28107 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 이미 초밥을 먹었는지 확인
        Set<Integer>[] eaten = new HashSet[N];
        for (int i = 0; i < N; i++) {
            eaten[i] = new HashSet<>();
        }

        // 스시번호당 먹고 싶은 사람 추가
        Map<Integer, List<Integer>> sushiOrderMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int k = sc.nextInt();
            for (int j = 0; j < k; j++) {
                int sushi = sc.nextInt();
                sushiOrderMap.putIfAbsent(sushi, new ArrayList<>());
                sushiOrderMap.get(sushi).add(i);
            }
        }

        int[] ans = new int[N];

        for (int i = 0; i < M; i++) {
            int sushi = sc.nextInt();

            if (!sushiOrderMap.containsKey(sushi)) continue; // 주문 목록에 없는 스시는 버린다

            List<Integer> customers = sushiOrderMap.get(sushi); // 해당 스시를 주문한 사람들
            for (int customer : customers) {
                if (!eaten[customer].contains(sushi)) { // 이미 먹었는지 확인
                    eaten[customer].add(sushi);
                    ans[customer]++;
                    break;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
