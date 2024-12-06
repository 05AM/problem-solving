import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        List<Coord> coords = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();

            coords.add(new Coord(x, y));
        }

        Collections.sort(coords);

        for (Coord coord : coords) {
            System.out.println(coord.x + " " + coord.y);
        }
    }
}

class Coord implements Comparable<Coord> {
    int x;
    int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Coord o) {
        if (this.y != o.y) {
            return this.y - o.y;
        }

        return this.x - o.x;
    }
}