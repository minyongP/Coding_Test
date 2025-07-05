package sort.merge;

import java.io.*;

public class P2751 {
    public static int[] A, tmp;
    public static void main(String[] args) throws IOException {
        /*
        * N(수의 개수) A(정렬할 배열) tmp(임시배열)
        * A초기화
        * 병합 정렬 실행
        * 결과 출력
        *
        * 병합 정렬(s, e) {
        *  s, e, m(시작, 끝, 중간)
        *  병합 정렬(s, m)
        *  병합 정렬(m+1, e)
        *  for(s~e)
        *   tmp 배열 저장
        * s1(앞쪽 시작지점)
        * s2(뒤쪽 시작지점)
        * while(s1 <= m && s2 <= e)
        *  양쪽 포인트를 비교해 더 작은 값을 배열에 저장
        *  선택된 데이터의 index 값을 오른쪽으로 한칸 이동
        *  반복문 끝난 후 남은 데이터 정리
        * }
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        tmp = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(1, N);
        for (int i = 1; i < N+1; i++) {
            bw.write(A[i] + "\n");
        }
        bw.flush();
    }

    private static void mergeSort(int s, int e) {
        if (e - s < 1) return;
        int m = s + (e-s) / 2;

        mergeSort(s, m);
        mergeSort(m+1, e);
        for (int i = s; i < e+1; i++) {
            tmp[i] = A[i];
        }

        int k = s;
        int s1 = s;
        int s2 = m+1;
        while (s1 <= m && s2 <= e) {
            if (tmp[s1] > tmp[s2]) {
                A[k] = tmp[s2];
                k++;
                s2++;
            } else {
                A[k] = tmp[s1];
                k++;
                s1++;
            }
        }
        while (s1 <= m) {
            A[k] = tmp[s1];
            k++;
            s1++;
        }
        while (s2 <= e) {
            A[k] = tmp[s2];
            k++;
            s2++;
        }
    }
}
