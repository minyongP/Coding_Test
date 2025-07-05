package sort.radix;

import java.io.*;

public class P10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(br.readLine());
        sort(A, 5); // 수가 10,000보다 작아 5로 설정
        for (int i = 0; i < N; i++) bw.write(A[i] + "\n");
        bw.flush();
    }

    private static void sort(int[] A, int size) {
        int[] output = new int[A.length];   // 임시 저장 배열
        int digit = 1;
        for (int k = 0; k < size; k++) {
            int[] box = new int[10]; // 0~9까지 자리수 배열
            for (int i = 0; i < A.length; i++) box[A[i]/digit%10]++;
            for (int i = 1; i < 10; i++) box[i] += box[i-1];
            for (int i = A.length-1; i >= 0; i--) {
                output[box[A[i]/digit%10]-1] = A[i];
                box[A[i]/digit%10]--;
            }
            for (int i = 0; i < A.length; i++) A[i] = output[i];
            digit *= 10;
        }
    }
}
