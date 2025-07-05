package base.stream;

import java.util.stream.LongStream;

public class PrefixSum {
    public static void main(String[] args) {
        // 1부터 400억까지 누적합 + 작업 시간


        long s = System.currentTimeMillis();
        long result = prefixSum(1, 40_000_000_000L);
        long e = System.currentTimeMillis();
        System.out.println(result);
        System.out.println("# 작업 시간: " + (e-s));
    }

    private static long prefixSum(int s, long e) {
        return LongStream.rangeClosed(s, e)
                .parallel() // 자동으로 병렬처리 해주어 속도가 엄청 향상된다!
                .reduce(0, Long::sum);
    }
}
