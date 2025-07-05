package datastructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        Queue<Integer> queue = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String method = st.nextToken();

            switch (method) {
                case "push": {
                    queue.add(Integer.parseInt(st.nextToken()));
                    break;
                }
                case "pop": {
                    if (queue.isEmpty()) sb.append(-1 + "\n");
                    else sb.append(queue.poll() + "\n");
                    break;
                }
                case "size": {
                    sb.append(queue.size() + "\n");
                    break;
                }
                case "empty": {
                    if (queue.isEmpty()) sb.append(1 + "\n");
                    else sb.append(0 + "\n");
                    break;
                }
                case "front": {
                    if (queue.isEmpty()) sb.append(-1 + "\n");
                    else sb.append(queue.peek() + "\n");
                    break;
                }
                case "back": {
                    if (queue.isEmpty()) sb.append(-1 + "\n");
                    else sb.append(((LinkedList<Integer>) queue).peekLast() + "\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}