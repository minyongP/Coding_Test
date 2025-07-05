package sort.bubble;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1377 {
    public static void main(String[] args) throws IOException {
        /*
        * N(배열 크기) A(수 배열)
        * for(N) A초기화
        * sort(A)
        * for(N)
        *   A[i]의 정렬전 index - 정렬후 index 최대값 저장
        * 최대값+1 출력
        * class mData() {
        *   index, value
        *   Comparable로 value 기준 오름차순 정렬
        * }
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        compare[] A = new compare[N];
        for (int i = 0; i < N; i++) {
            A[i] = new compare(Integer.parseInt(br.readLine()), i);
        }
        Arrays.sort(A);
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (max < A[i].index - i)
                max = A[i].index - i;
        }
        System.out.println(max+1);
    }

    private static class compare implements  Comparable<compare>{
        int value, index;

        public compare(int value, int index) {
            super();
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(compare o) {
            return this.value - o.value;
        }
    }
}