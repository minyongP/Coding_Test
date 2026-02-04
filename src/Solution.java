import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			char[][] A = new char[100][100];

			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				A[i] = st.nextToken().toCharArray();
			}

			long ans = 1;
			for (int len = 100; len >= 1; len--) {
				boolean found = false;

				// 가로 검사
				for (int r = 0; r < 100 && !found; r++) {
					for (int s = 0; s + len <= 100; s++) {
						if (isPalRow(A, r, s, len)) {
							ans = len;
							found = true;
							break;
						}
					}
				}

				// 세로 검사
				for (int c = 0; c < 100 && !found; c++) {
					for (int s = 0; s + len <= 100; s++) {
						if (isPalCol(A, c, s, len)) {
							ans = len;
							found = true;
							break;
						}
					}
				}

				if (found) break;
			}

			System.out.println("#" + T + " " + ans);
		}
	}

	static boolean isPalRow(char[][] A, int r, int start, int len) {
		int l = start;
		int rr = start + len - 1;
		while (l < rr) {
			if (A[r][l] != A[r][rr]) return false;
			l++;
			rr--;
		}
		return true;
	}

	static boolean isPalCol(char[][] A, int c, int start, int len) {
		int t = start;
		int b = start + len - 1;
		while (t < b) {
			if (A[t][c] != A[b][c]) return false;
			t++;
			b--;
		}
		return true;
	}
}