package math;
/*
수열을 구해보자
1 = 1       1
2~7 = 2     6
8~19 = 3    12
20~37 = 4   18
38~61 = 5   24?
62~   = 6   30?
N(도착할 방) count(도착하기 위한 지나갈 방 개수)
N--
count = 1
while(N=<0)
    N -= 6*count
    count++
count 출력
*/

import java.util.Scanner;

public class P2292 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt()-1;
        int count = 1;
        int p = 0;
        while (N > 0) {
            N -= 6 * count;
            count++;
        }
        System.out.println(count);
    }
}