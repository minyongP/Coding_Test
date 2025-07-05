package base;

import java.util.ArrayList;

public class SubsetSum {
    public static void main(String[] args) {
        int output = subsetSum(new int[]{1, 8, 3, 15}, 10);
        System.out.println(output); // --> 9 (= 1 + 8)

        output = subsetSum(new int[]{20, 80, 99, 27, 35}, 100);
        System.out.println(output); // --> 100 (= 20 + 80)

        output = subsetSum(new int[]{10, 20, 15, 25, 30}, 5);
        System.out.println(output); // --> 0
    }

    private static int subsetSum(int[] set, int bound) {
        int max = 0;
        // 집합의 원소들로 만들 수 있는 합의 조합을 관리하는 배열
        // bound는 최대 300이므로, 배열의 크기를 301로 설정한다.
        // 300 + 1 로 적는 이유는 가독성과 배열 인덱스를 직관적으로 관리하기 위함
        // 원소들을 통해 sum을 만들 수 있는 경우, bound[sum]을 true로 설정한다.

        boolean[] cached = new boolean[301];
        for(int member : set) {
            // 집합의 원소를 차례대로 검사
            // 이전 단계까지 검사한 원소들로 만들 수 있는 합의 조합은 cached에 저장되어 있다.
            // cached의 요소에 각각 member를 더한 값을 만들 수 있다.
            ArrayList<Integer> reachables = new ArrayList<>();
            // 이 중에서 bound를 넘어가는 값은 고려하지 않는다.
            // reachables로 따로 관리하는 이유는 중복 계산을 피하기 위함
            for(int wanted = 1; wanted <= bound - member; wanted++) { // 반복횟수는 바운드에서 현재 값을 뺀 만큼
                if(cached[wanted]) {
                    int reached = wanted + member;
                    reachables.add(reached);
                    if(reached > max) max = reached; // 최대값이면 갱신
                }
            }

            // bound 이하로 만들 수 있는 합의 조합을 cached에 추가한다.
            for(int data : reachables) cached[data] = true;

            // 집합의 원소를 마지막에 cached에 추가하는 이유는 중복 계산을 방지하기 위함
            if (member <= bound) {
                cached[member] = true;
                if (member > max) max = member;
            }
        }
        return max;
    }
}
