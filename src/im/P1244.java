package im;

import java.util.HashSet;
import java.util.Scanner;

public class P1244 {
	static int K;
	static String max;
	static HashSet<String>[] visited;

	static void dfs(char[] A, int depth) {
		String cur = new String(A);

		if (visited[depth].contains(cur)) return;
		visited[depth].add(cur);

		if (depth == K) {
			if (cur.compareTo(max) > 0) max = cur;
			return;
		}

		int n = A.length;
		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j < n; j++) {
				char temp = A[i];
				A[i] = A[j];
				A[j] = temp;

				dfs(A, depth + 1);

				temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			max = "0";
			System.out.print("#" + test_case + " ");
			char[] A = sc.next().toCharArray();
			K = sc.nextInt();

			visited = new HashSet[K+1];
			for (int i = 0; i < K+1; i++) {
				visited[i] = new HashSet<>();
			}

			dfs(A, 0);
			System.out.println(Integer.parseInt(max));
		}
	}
}
