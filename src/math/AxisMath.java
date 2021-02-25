package math;
import java.awt.Point;

public class AxisMath {
	public static double GetDistanceBetweenPoints(Point p1, Point p2) {
		return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
	}
}
