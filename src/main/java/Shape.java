import java.util.*;

/**
 * Represents a polygon shape defined by a list of points.
 */
public class Shape {
    private List<Point> points;

    /**
     * Constructs a Shape from a string of coordinates.
     * Example: "0 0  0 1  1 1  1 0"
     * @param data string of coordinates
     */
    public Shape(String data) {
        points = new ArrayList<>();
        String[] tokens = data.trim().split("\\s+");
        for (int i = 0; i < tokens.length; i += 2) {
            double x = Double.parseDouble(tokens[i]);
            double y = Double.parseDouble(tokens[i + 1]);
            points.add(new Point(x, y));
        }
    }

    /**
     * Returns the list of points.
     * @return list of points
     */
    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    /**
     * Returns the perimeter of the polygon.
     * @return perimeter
     */
    public double getPerimeter() {
        double peri = 0;
        for (int i = 0; i < points.size(); i++) {
            Point a = points.get(i);
            Point b = points.get((i + 1) % points.size());
            peri += a.distance(b);
        }
        return peri;
    }

    /**
     * Returns the area of the polygon (Shoelace formula).
     * @return area
     */
    public double getArea() {
        double sum = 0;
        for (int i = 0; i < points.size(); i++) {
            Point a = points.get(i);
            Point b = points.get((i + 1) % points.size());
            sum += (a.getX() * b.getY()) - (b.getX() * a.getY());
        }
        return Math.abs(sum) / 2.0;
    }

    /**
     * Returns string representation of the shape.
     */
    public String toString() {
        return points.toString();
    }
}
