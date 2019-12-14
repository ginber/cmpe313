/**
 * A class to represent the objects in the plane's surrounding.
 */

package utilities;

import java.util.List;

public class Surroundings {
	
	private Point3D coordinate;  // Coordinate of the object
	private List<Point3D> shape;  // Edges of the object -> shape of it can be decided from the edges
	
	// Hide the constructor with no parameters
	private Surroundings() {}
	
	/**
	 * Constructor which also sets coordinate and shape fields of the object.
	 * @param coordinate Current coordinate of the object
	 * @param shape Edge points of the object as a list to decide the sahpe of the object
	 */
	public Surroundings(Point3D coordinate, List<Point3D> shape) {
		this.coordinate = coordinate;
		this.shape = shape;
	}
	
	/**
	 * This method is used to calculate the area of the {@code Surroundings} 
	 * @return area of the surrounding object
	 */
	public double getSize() {
		double area = 0.0;
		// Calculate the area of the object according to its {@code shape}
		return area;
	}
	
	/**
	 * This method is used to calculate the distance of the surrounding object from the plane.
	 * @return distance of the object from the plane
	 */
	public double getDistanceFromPlane() {
		double distance = 0.0;
		// Calculate the distance of the surrounding object to plane by comparing their coordinates
		return distance;
	}
	
	@Override
	public String toString() {
		return "Surroundings [coordinate=" + coordinate + ", shape=" + shape + "]";
	}
	
	// Getters
	
	public Point3D getCoordinate() {
		return coordinate;
	}

	public List<Point3D> getShape() {
		return shape;
	}

}
