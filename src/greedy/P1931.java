package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class P1931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Table[] tables = new Table[N];

        for (int i = 0; i < N; i++) {
            tables[i] = new Table(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(tables);

        int cnt = 0;
        int lastTime = 0;

        for (Table table : tables) {
            if (lastTime <= table.start) {
                lastTime = table.end;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
class Table implements Comparable<Table> {
    int start;
    int end;

    public Table(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Table other) {
        if (this.end == other.end) {
            return this.start - other.start;
        }
        return this.end - other.end;
    }
}
