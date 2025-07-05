package base;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class PrimePassword {
    public static void main(String[] args) {
        int output = primePassword(1033, 1033);
        System.out.println(output); // --> 0

        output = primePassword(3733, 8779);
        System.out.println(output); // --> 3 (3733 -> 3739 -> 3779 -> 8779)

        output = primePassword(1009, 1171);
        System.out.println(output); // --> 5

        output = primePassword(9797, 9923);
        System.out.println(output); // --> 6

    }

    private static int primePassword(int curPwd, int newPwd) {
        if (curPwd == newPwd) {
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[10000];
        queue.offer(new int[]{0, curPwd});

        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            int cnt = data[0];
            int pw = data[1];
            for (int i = 0; i < 4; i++) {
                int[] digit = Stream.of(String.valueOf(pw).split("")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < 10; j++) {
                    if (j != digit[i]) {
                        digit[i] = j;
                        int curpw = combineNum(digit);
                        if (curpw == newPwd) return cnt+1;
                        if (curpw > 1000 && isPrime(curpw) && !visited[curpw]) {
                            visited[curpw] = true;
                            queue.offer(new int[]{cnt+1, curpw});
                        }
                    }
                }
            }
        }
        return -1;
    }

    private static int combineNum(int[] digit) {
        StringBuffer sb = new StringBuffer();
        for (int n : digit) {
            sb.append(n);
        }
        return Integer.parseInt(sb.toString());
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
