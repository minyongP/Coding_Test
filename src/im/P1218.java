package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1218 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int test_case = 1; test_case <= 10; test_case++) {
            Deque<Character> deque = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            char[] A = new StringTokenizer(br.readLine()).nextToken().toCharArray();

            int ans = 1;
            for (int i = 0; i < n; i++) {
                char c = A[i];
                if (c == ')') {
                    if (deque.pop() != '(')  {
                        ans = 0; break;
                    }
                }
                else if (c == ']'){
                    if (deque.pop() != '[') {
                        ans = 0; break;
                    }
                }
                else if (c == '}'){
                    if (deque.pop() != '{') {
                        ans = 0; break;
                    }
                }
                else if (c == '>'){
                    if (deque.pop() != '<') {
                        ans = 0; break;
                    }
                }
                else deque.push(c);
            }
            System.out.println("#" + test_case + " " + ans);
        }
    }
}