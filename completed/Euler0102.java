package completed;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Euler0102 {

    public static void main(String[] args) {
        try {
            FileReader input = new FileReader("Euler0102_triangles.txt");
            BufferedReader bufRead = new BufferedReader(input);

            String regex = ",";
            Pattern pattern = Pattern.compile(regex);

            String line;
            int count = 0;
            line = bufRead.readLine();

            Point po = new Point(0, 0);

            while (line != null) {
                String[] splited = pattern.split(line);
                Point p1 = new Point(Integer.parseInt(splited[0]), Integer.parseInt(splited[1]));
                Point p2 = new Point(Integer.parseInt(splited[2]), Integer.parseInt(splited[3]));
                Point p3 = new Point(Integer.parseInt(splited[4]), Integer.parseInt(splited[5]));

                line = bufRead.readLine();

                int a = 0;
                if (isLeft(p1, p2, po) >= 0) {
                    a++;
                }
                if (isLeft(p2, p3, po) >= 0) {
                    a++;
                }
                if (isLeft(p3, p1, po) >= 0) {
                    a++;
                }
                if (a == 0 || a == 3) {
                    count++;
                }
            }
            System.out.println(count);
            bufRead.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int isLeft(Point a, Point b, Point c) {
        return ((b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x));
    }
}
