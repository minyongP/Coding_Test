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

			long max = 0;
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					// 가로
					int temp = 0;
					for (int k = 0 ; k <= Math.min(j, 99-j); k++) {
						if (A[i][j-k] != A[i][j+k]) break;
						temp++;
					}
					max = Math.max(max, temp);
					//세로
					temp = 0;
					for (int k = 0; k <= Math.min(i, 99-i); k++) {
						if (A[i-k][j] != A[i+k][j]) break;
						temp++;
					}
					max = Math.max(max, temp);
				}
			}

			System.out.println("#" + T + " " + max);
		}
	}
}