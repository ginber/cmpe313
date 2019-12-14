/**
 * Route implementation for the plane.
 */

package utilities;

import java.util.LinkedList;
import java.util.List;

public class Route {
	
	private List<Point3D> checkPoints;  // turning points in the route - checkpoints
	
	/**
	 * Creates a {@code Route} object with initially an empty set of checkpoints.
	 */
	public Route() {
		checkPoints = new LinkedList<Point3D>();
	}
	
	/**
	 * Creates a {@code Route} object with given edges
	 * @param checkPoints must-visit points in the [{@code Route}
	 */
	public Route(List<Point3D> checkPoints) {
		this.checkPoints = checkPoints;
	}
	
	/**
	 * Adds a new checkpoint to the route if it is appropriate to the {@code Route}
	 * @param cP checkpoint to be added
	 * @return if the operation was successful
	 */
	public boolean addCheckPoint(Point3D cP) {
		boolean isValid;  // check if the point can be added to the route
		isValid = (cP.x > 5) ? true : false;  // dummy code for testing
		if(isValid) {
			checkPoints.add(cP);
			return isValid;
		}
		return isValid;
	}
	
	/**
	 * This method is used to calculate and to get the nearest checkpoint to the plane at the time
	 * @return nearest checkpoint to the plane
	 */
	public Point3D getNearestCheckPoint() {
		// dummy code for testing
		for(int i = 0; i < checkPoints.size(); i++) {
			if(checkPoints.get(i).x == 6) {
				return checkPoints.get(i);
			}
		}
		return null;
	}
	
	/**
	 * This method is used to calculate and to get the approximate cost of the {@code Route}
	 * @return approximate cost of the route
	 */
	public double getApproximateCost() {
		double approximateCost = 0.0;
		// Calculate the approximate cost here
		return approximateCost;
	}
	
	/**
	 * This method is used to get the final coordinate of the route, which is the target coordinate of the flight
	 * @return target coordinate of the flight
	 */
	public Point3D getTargetCoordinate() {
		return checkPoints.get(checkPoints.size() - 1);
	}
	
	// Getter & Setter
	
	public List<Point3D> getCheckPoints() {
		return checkPoints;
	}
	
	public void setCheckPoints(List<Point3D> checkPoints) {
		this.checkPoints = checkPoints;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Route [checkPoints=" + checkPoints + "]";
	}
	

}
