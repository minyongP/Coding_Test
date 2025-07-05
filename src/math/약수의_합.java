package math;

public class 약수의_합 {
    public static void main(String[] args) {
        int n = 12;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) ans += i;
        }
        System.out.println(ans);
    }
}
