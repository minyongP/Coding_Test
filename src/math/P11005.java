package math;
/*
N(10진법 수) B(변경할 진법)
A(변경된 진법 수 리스트)
while(나머지 값이 B보다 작을때 까지)
    A에 나머지 값을 저장
A를 뒤집는다
for(A 크기만큼 반복)
    if(10 이상이면)
        숫자를 문자로 변경
A 출력
*/
import java.util.*;

public class P11005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int B = scanner.nextInt();
        ArrayList<Character> A = new ArrayList<>();
        while (N >= B) {
            A.add((char) (N % B + '0'));
            N = N / B;
        }
        A.add((char) (N + '0'));
        Collections.reverse(A);
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > 57) A.set(i, (char) (A.get(i) + 7));
        }
        for (char i : A) System.out.print(i);
    }
}