import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class StudentGrade implements Comparable<StudentGrade> {
        String name;
        int korean, english, math;

        public StudentGrade(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(StudentGrade o) {
            if (this.korean != o.korean) {
                return o.korean - this.korean;
            }

            if (this.english != o.english) {
                return this.english - o.english;
            }

            if (this.math != o.math) {
                return o.math - this.math;
            }

            return this.name.compareTo(o.name);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        StudentGrade[] grades = new StudentGrade[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            grades[i] = new StudentGrade(name, korean, english, math);
        }

        Arrays.sort(grades);

        for (StudentGrade grade : grades) {
            System.out.println(grade.name);
        }
    }
}
