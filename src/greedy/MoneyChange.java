package greedy;

import java.util.Arrays;

public class MoneyChange {
    public static void main(String[] args) {
        long output = ocean(50, new int[]{10, 20, 50});
        System.out.println(output); // 4

        output = ocean(100, new int[]{10, 20, 50});
        System.out.println(output); // 10

        output = ocean(30, new int[]{5, 6, 7});
        System.out.println(output); // 4
    }

    private static long ocean(int target, int[] type) {
        /*
        * 잔돈배열 정렬(오름,내림은 상관없지만 오름으로)
        * dp[](금액에서 가능한 경우의 수)
        * dp[0]초기화
        *
        * for(잔돈배열){
        *   for(목표금액만큼){
        *       경우의수 배열을 이전배열에서 경우의수에서 추가해 초기화
        *   }
        * }
        * 목표금액의 경우의수 반환
        * */
        Arrays.sort(type);
        long[] dp = new long[target + 1];
        dp[0] = 1; // 0원을 만들 수 있는 방법은 한 가지 (아무 동전도 사용하지 않음)

        for (int coin : type) {
            for (int i = coin; i <= target; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[target];
    }
}
