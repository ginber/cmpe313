/**
 * 3D Point implementation. 
 */

package utilities;

public class Point3D {
	
	// x, y and z coordinates of the point in the 3 dimensional coordinate system
	protected double x, y, z;
	
	/**
	 * Creates a Point3D object and initializes its coordinates with given parameters.
	 * @param x x coordinate of the point
	 * @param y y coordinate of the point
	 * @param z z coordinate of the point
	 */
	public Point3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;			
	}
	
	@Override
	public String toString() {
		return "Point3D [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

	// Getters & setters
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

}
