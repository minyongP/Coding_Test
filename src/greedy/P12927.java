package greedy;

import java.io.*;

public class P12927 {
	static boolean[] bulb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] temp = br.readLine().toCharArray();
		bulb = new boolean[temp.length+1];
		int j = 1;
		for (char c : temp) bulb[j++] = c == 'Y' ? true : false;

		int result = 0;
		for (int i  = 1; i < bulb.length; i++){
			if (bulb[i]){
				reverse(i);
				result++;
			}
		}
		System.out.println(result);
	}

	private static void reverse(int i) {
		for (int j = i; j <bulb.length; j+=i) bulb[j] = !bulb[j];
	}
}
