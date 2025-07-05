package datastructure.stack;

import java.util.Scanner;
import java.util.Stack;

/*
N(수열 개수) A[](수열 배열)
수열 배열 채우기
for(N){
    if(현재 수열 값 >= 오름차순 자연수) {
        while(같아질 때까지){
            push()
            +저장
        }
        pop()
        -저장
        }
    else{
        pop()
        if(스택 pop 결과값 > 수열의 수) NO출력
        else -저장
        }
}
if(NO를 출력한 적이 없으면) 저장한 값 출력
*/
public class P1874 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int A[] = new int[n];
        StringBuffer sb = new StringBuffer();
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean result = true;

        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (A[i] >= num) {  // push 해야할 경우
                // 같아 질때까지 push
                while (A[i] >= num) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                // 같아지면 pop해서 출력
                stack.pop();
                sb.append("-\n");
            }else {             // pop 해야할 경우
                if (A[i] < stack.pop()) {         // NO인 경우
                    result = false;
                    System.out.println("NO");
                    break;
                }else sb.append("-\n");
            }
        }
        if (result) System.out.println(sb.toString());
    }
}