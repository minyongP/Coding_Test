package datastructure.Map;

import java.util.*;

public class P25325 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Student> studentList = new ArrayList<>();
        for (String name : sc.nextLine().split(" ")) {
            studentList.add(new Student(name));
        }

        for (int i = 0; i < n; i++) {
            for (String name :  sc.nextLine().split(" ")) {
                Student student =  studentList.stream()
                        .filter(s -> s.getName().equals(name))
                        .findFirst()
                        .orElse(null);
                student.setIngido(student.getIngido() + 1);
            }
        }

        studentList.sort(Comparator.comparing(Student::getIngido).reversed());

        for (Student student : studentList) {
            System.out.println(student.getName() + " " + student.getIngido());
        }

    }

    static class Student implements Comparable<Student>{
        String name;
        int ingido;

        public Student(String name) {
            this.name = name;
            this.ingido = 0;
        }

        public String getName() {
            return name;
        }

        public int getIngido() {
            return ingido;
        }

        public void setIngido(int ingido) {
            this.ingido = ingido;
        }

        @Override
        public int compareTo(Student o) {
            int diff = o.ingido - this.ingido; // 내림차순
            if (diff != 0) return diff;
            return this.name.compareTo(o.name);
        }
    }
}
