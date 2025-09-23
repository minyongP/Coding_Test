import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine()); // 학생 수
        String[] students = sc.nextLine().split(" "); // 학생 이름 배열
        Map<String, Integer> popularity = new HashMap<>();
        for (String s : students) popularity.put(s, 0);

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] likes = line.split(" ");
            for (String likedStudent : likes) {
                popularity.put(likedStudent, popularity.get(likedStudent) + 1);
            }
        }

        List<String> studentList = new ArrayList<>(Arrays.asList(students));
        studentList.sort((a, b) -> {
            int diff = popularity.get(b) - popularity.get(a);
            if (diff != 0) return diff;
            return a.compareTo(b);
        });

        for (String s : studentList) System.out.println(s + " " + popularity.get(s));
    }
}
