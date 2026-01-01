package greedy;

import java.io.*;

public class P12927 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] temp = br.readLine().toCharArray();
		boolean[] bulb = new boolean[temp.length+1];
		int k = 1;
		for (char c : temp) bulb[k++] = c == 'Y' ? true : false;

		int result = 0;
		for (int i  = 1; i < bulb.length; i++){
			if (bulb[i]){
				for (int j = i; j <bulb.length; j+=i) bulb[j] = !bulb[j];
				result++;
			}
		}
		System.out.println(result);
	}
}
