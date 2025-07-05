package combination;

public class NewBlackjack {
    public static void main(String[] args) {
        int output = boringBlackjack(new int[]{1, 2, 3, 4});
        System.out.println(output); // 1

        int output2 = boringBlackjack(new int[]{2, 3, 4, 8, 13});
        System.out.println(output2); // 3
    }

    private static int boringBlackjack(int[] cards) {
        /*
        * cards.length에서 3장을 뽑는다
        * 3장의 합을 구한다
        * 소수인지 판별한다
        * */
        int count = 0;
        int length = cards.length;
        // 3장이 정해졌으므로 중첩반복문으로 구하기(3장 이하는 중첩으로 하는게 더 좋을 수 있다.)
        // 중복 불가 조합이므로 nCr 다음 반복문의 시작점은 이전의 다음것
        for(int i = 0; i < length; i++) {
            for(int j = i + 1; j < length; j++) {
                for(int k = j + 1; k < length; k++) {
                    int number = cards[i] + cards[j] + cards[k];
                    if(isPrime(number)) count++;
                }
            }
        }
        return count;
    }

    private static boolean isPrime(int number) {
        // 소수 구하기 이전에 배웠다.
        for(int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) return false;
        }
        return true;
    }
}
