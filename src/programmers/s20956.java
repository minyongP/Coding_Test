package programmers;

import java.util.*;

public class s20956 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            String S = sc.nextLine();
            String E = sc.nextLine();
            if (BFS(S, E)) {
                System.out.println("#"+ (t+1) + " YES");
            } else System.out.println("#"+ (t+1) + " NO");
        }
    }

    private static boolean BFS(String S, String E) {
        if (S.equals(E)) return true;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(S);
        visited.add(S);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (current.length() > E.length()) continue;

            if (current.equals(E)) {
                return true;
            }

            String next1 = current + "X";
            if (!visited.contains(next1) && next1.length() <= E.length()) {
                queue.add(next1);
                visited.add(next1);
            }

            String next2 = new StringBuilder(current + "Y").reverse().toString();
            if (!visited.contains(next2) && next2.length() <= E.length()) {
                queue.add(next2);
                visited.add(next2);
            }
        }

        return false;
    }
}
