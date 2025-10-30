package datastructure.queue;

import java.io.*;
import java.util.*;

public class P2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n*n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                a[idx++] =  Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(a);
        System.out.println(a[n*n-n]);
    }
}
