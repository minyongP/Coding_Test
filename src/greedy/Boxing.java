package greedy;

import java.util.Arrays;

public class Boxing {
    public static void main(String[] args) {
        int output = movingStuff(new int[]{70, 50, 80, 50}, 100);
        System.out.println(output); // 3

        int output2 = movingStuff(new int[]{60, 80, 120, 90, 130}, 140);
        System.out.println(output2); // 4

        int output3 = movingStuff(new int[]{42, 25, 60, 73, 103, 167}, 187);
        System.out.println(output3); // 4
    }

    private static int movingStuff(int[] stuff, int limit) {
        /*
        * count(같이 담을 수 있는 수)
        * 배열 오름차순 정렬
        * two point
        * while(s<e){
        *   if(배열의 s, e 더해서 리미트 이하){
        *       count++
        *       s++, e--
        *   }else e--
        * }
        *배열크기에서 카운트만큼 차감해 출력
        * */

        int count = 0;
        Arrays.sort(stuff);
        int s = 0;
        int e = stuff.length-1;
        while (s < e) {
            if (stuff[s] + stuff[e] <= limit){
                count++; s++; e--;
            }else e--;
        }
        return stuff.length - count;
    }
}
