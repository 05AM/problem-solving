import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        List<Member> members = new ArrayList<>();

        for (int i = 0, order = 1; i < n; i++, order++) {
            int age = in.nextInt();
            String name = in.next();

            members.add(new Member(order, age, name));
        }

        Collections.sort(members);

        for (Member member : members) {
            System.out.println(member.age + " " + member.name);
        }
    }
}

class Member implements Comparable<Member> {
    int order;
    int age;
    String name;

    public Member(int order, int age, String name) {
        this.order = order;
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Member o) {
        if (this.age != o.age) {
            return this.age - o.age;
        }

        return this.order - o.order;
    }
}