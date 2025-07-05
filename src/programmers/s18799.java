package programmers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

public class s18799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> A = new ArrayList<>();
        int T = sc.nextInt();
        for(int i = 0; i < T; i++) {
            int sum = 0;
            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                int input = sc.nextInt();
                A.add(input);
                sum += input;
            }
            System.out.println("#" + i+1 + " " + avg(sum, n));
            A.clear();
        }
    }

    private static String avg(int sum, int n) {
        double ans = (double) sum /n;
        BigDecimal bd = new BigDecimal(Double.toString(ans));
        bd = bd.setScale(20, RoundingMode.HALF_UP);

        String str = bd.toPlainString();

        if (str.indexOf(".") > 0){
            str = str.replaceAll("0*$", "");
            str = str.replaceAll("\\.$", "");
        }

        return str;
    }
}

/*int T test 횟수
int[] A <=8
int sum
for(T){
int n(집합크기)
for(n){A[i] = input / sum += input}
avg(sum, n){
ans = sum/n (소수점 이하 20자리) *!소수점이하 0은 출력하지않는다
if ans % 1 = 0.0 return ans/1
else String.format(%.20f, ans
}

* */
