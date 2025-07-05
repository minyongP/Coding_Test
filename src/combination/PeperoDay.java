package combination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PeperoDay {
    public static void main(String[] args) {
        int M = 4;
        int N = 8;
        ArrayList<Integer[]> output = divideChocolateStick(M, N);
        System.out.println(output);
        // [[1, 4, 8], [2, 2, 4], [4, 1, 2]]

    }


    public static ArrayList<Integer[]> divideChocolateStick(int M, int N) {
        /*
        * 똑같이 나눠줘야하므로 최대공약수
        * N, M ≤ 1,000,000,000 최악 10초
        * 1,000,000,000의 제곱근은 약31,623 1초 미만
        * result(정답 배열)
        * GCD(최대공약수)
        * sqrt(GCD 루트값)
        *for(1~sqrt){
        *   if(나눌 수 있는 경우)
        *       (i, M/i, N/i) 저장
        *       if(제곱해서 GCD보다 작을 경우)
        *           (j(GCD / i), M/j, N/j) 저장
        * }
        * 정답 반환
        * */
        ArrayList<Integer[]> result = new ArrayList<>();

        int GCD = gcd(M, N);

//        int sqrt = (int)Math.floor(Math.sqrt(GCD));
        int sqrt = (int) Math.sqrt(GCD);

        // 앞 뒤를 동시에 해 줄이기
        for(int left = 1; left <= sqrt; left++) {
            if(GCD % left == 0) {   // 기본적으로 앞에서부터 나눌 수 있는 경우
                result.add(new Integer[]{left, M / left, N / left});
                if(left * left < GCD) { // 뒤에서부터(최대공약수보다 작은 수) 나눌 수 있는 경우
                    int right = GCD / left;
                    result.add(new Integer[]{right, M / right, N / right});
                }
            }
        }
        // 정렬 안해도 된다
        // '빼빼로를 받게 되는 직원의 수'를 기준으로 오름차순으로 정렬
//        Collections.sort(result, new Comparator<Integer[]>() {
//            @Override
//            public int compare(Integer[] o1, Integer[] o2) {
//                return o1[0].compareTo(o2[0]);
//            }
//        });

        return result;
    }

    public static int gcd(int m, int n) {
        if (m % n == 0) return n;
        return gcd(n, m % n);
    }
}