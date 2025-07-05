package datastructure.stack;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class P17298 {
    public static void main(String[] args) throws IOException {
        /*
        * N(수열의 크기) A(수열 배열) ans(정답 배열)
        * push(0)
        * for(1~N만큼 반복){
        *   while(not empty & 현재 수열 값이 top에 해당하는 수열보다 클때 까지){
        *   ans(pop) = A[i];
        *   }
        *   현재 인덱스 push
        * }
        * while(스택이 빌 때까지){
        *   스택에 있는 인덱스의 정답 배열에 -1저장
        * }
        * 정답 출력
        * */
        Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = scanner.nextInt();
//        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] ans = new int[N];
        Stack<Integer> stack = new Stack<>();
//        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A.length; i++) {
            A[i] = scanner.nextInt();
//            A[i] = Integer.parseInt(st.nextToken());
        }
        stack.push(0);
        for (int i = 1; i < N; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                ans[stack.pop()] = A[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }
        for (int i = 0; i < N; i++) {
            bw.write(ans[i] + " ");
        }
        bw.flush();
    }
}