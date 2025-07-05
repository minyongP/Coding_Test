package greedy;

public class CoinChange {
    public static void main(String[] args) {
        // 4000원을 받았을 때 500원짜리 동전 8개를 반환합니다.
        int output1 = partTimeJob(4000);
        System.out.println(output1); // --> 8

// 4972원을 받았을 때 500원짜리 동전 9개, 100원짜리 동전 4개, 50원짜리 동전 1개, 10원짜리 동전 2개, 1원짜리 동전 2개, 총 18개를 반환합니다.
        int output2 = partTimeJob(4972);
        System.out.println(output2); // --> 18
    }

    private static int partTimeJob(int k) {
        /*
        * change(잔돈), count(총 동전개수)
        * coins[](동전 배열 생성)
        * for(동전 배열 크기){
        *   count += change / conis[i];   동전개수
        *   change %= coins[i];    거스름돈 갱신
        *}
        * 동전 수 반환
        * */
        int[] coins = {500, 100, 50, 10, 5, 1};
        int change = k;
        int count = 0;

        for (int i = 0; i < coins.length; i++) {
            count += change / coins[i];
            change %= coins[i];
        }

        return count;
    }
}
