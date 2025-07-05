package sort.merge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * N(수의 개수) A(수 배열) tmp(임시배열)
 * A초기화
 * 병합정렬 실행
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
 * while(s1 <= m && s2 <= e){
 *  양쪽 포인트를 비교해 더 작은 값을 배열에 저장
 *  (swap이 일어났다 가정하고, 현재 남아 있는 앞쪽 데이터 개수만큼 결과값을 더한다.)
 *  선택된 데이터의 index 값을 오른쪽으로 한칸 이동
 * }
 *  반복문 끝난 후 남은 데이터 정리
 * }
 *
 * */
public class P1517 {
    static int[] A, tmp;
    static long result;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        tmp = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = 1;
        while (st.hasMoreTokens()) {
            A[p] = Integer.parseInt(st.nextToken());
            p++;
        }
        result = 0;
        mergeSort(1, N);
        System.out.println(result);
    }

    private static void mergeSort(int s, int e) {
        if (e-s < 1) return;
        int m = s + (e-s) / 2;

        mergeSort(s, m);
        mergeSort(m+1, e);

        for (int i = s; i <= e; i++) {
            tmp[i] = A[i];
        }

        int k = s;
        int s1 = s;
        int s2 = m+1;
        while (s1 <= m && s2 <= e) {
            if (tmp[s1] > tmp[s2]) {
                A[k] = tmp[s2];
                result += s2-k; // 뒤쪽이 더 작으면 업데이트
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