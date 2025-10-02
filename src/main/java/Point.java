/**
 * Immutable 2D point with x and y coordinates.
 */
public class Point {
	private double x;
	private double y;

	/**
	 * Constructs a new point with given coordinates.
	 * @param x x coordinate
	 * @param y y coordinate
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Copy constructor.
	 * @param other point to copy
	 */
	public Point(Point other) {
		this.x = other.x;
		this.y = other.y;
	}

	/**
	 * Returns the x coordinate.
	 * @return x
	 */
	public double getX() {
		return x;
	}

	/**
	 * Returns the y coordinate.
	 * @return y
	 */
	public double getY() {
		return y;
	}

	/**
	 * Returns a new point shifted by dx and dy.
	 * @param dx shift in x
	 * @param dy shift in y
	 * @return shifted point
	 */
	public Point shiftedPoint(double dx, double dy) {
		return new Point(x + dx, y + dy);
	}

	/**
	 * Returns the distance to another point.
	 * @param other other point
	 * @return distance
	 */
	public double distance(Point other) {
		double dx = x - other.x;
		double dy = y - other.y;
		return Math.sqrt(dx * dx + dy * dy);
	}

	/**
	 * Returns a string representation "x y".
	 * @return string representation
	 */
	public String toString() {
		return x + " " + y;
	}

	/**
	 * Compares two points for equality (by x and y values).
	 * @param object other object
	 * @return true if same coordinates
	 */
	public boolean equals(Object object) {
		if (!(object instanceof Point)) return false;
		Point other = (Point) object;
		return other.x == x && other.y == y;
	}
}
