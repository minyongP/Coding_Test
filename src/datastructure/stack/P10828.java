package datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String method = st.nextToken();
            switch (method) {
                case "push": {
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                }
                case "pop": {
                    if (stack.isEmpty()) sb.append(-1 + "\n");
                    else sb.append(stack.pop() + "\n");
                    break;
                }

                case "size": {
                    sb.append(stack.size() + "\n");
                    break;
                }

                case "empty": {
                    if (stack.isEmpty()) sb.append(1 + "\n");
                    else sb.append(0 + "\n");
                    break;
                }
                case "top": {
                    if (stack.isEmpty()) sb.append(-1 + "\n");
                    else sb.append(stack.peek() + "\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}