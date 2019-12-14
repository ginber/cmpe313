/**
 * 
 */

package systems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import utilities.*;

public class AircraftNavigationSystem implements Subject {
	
	// information about plane's current state
	private double currentSpeed, noseConeAngle;
	private Point3D currentCoordinate, targetCoordinate;
	private List<Surroundings> surroundings;
	private List<Route> possibleRoutes;
	private List<Observer> observerList;
	private Route bestRoute, currentRoute;
	private boolean onCourse, onAutopilot, stateChanged;
	
	// Singleton to prevent multiple instance creations
	private AircraftNavigationSystem ans = new AircraftNavigationSystem();
	
	private AircraftNavigationSystem() {
		// initialize List objects and boolean variable which will be used for Observer Design Pattern
		surroundings = new ArrayList<>();
		possibleRoutes = new ArrayList<>();
		observerList = new ArrayList<>();
		stateChanged = false;
	}
	
	public AircraftNavigationSystem loadANS() {
		return ans;
	}
	
	/**
	 * Plans all possible routes for the plane and returns the most optimal one.
	 * Planned routes are added into {@code possibleRoutes}
	 * @return route which is the most optimal
	 */
	public Route planRoutes() {
		bestRoute = new Route();
		Route newRoute = new Route();
		possibleRoutes.add(newRoute);
		stateChanged = true;
		notifyObserver();
		return bestRoute;
	}
	
	/**
	 * Checks objects near the plane and updates their position and size from plane's perspective
	 * in the {@code surroundings} list.
	 */
	public void checkSurroundings() {
		surroundings.add(new Surroundings(new Point3D(0, 0, 0), new LinkedList<Point3D>()));
		stateChanged = true;
		notifyObserver();
	}
	
	/**
	 * Updates and returns the current coordinate of the plane
	 * @return A Point3D object to represent the position of the plane
	 */
	public Point3D checkPosition() {
		currentCoordinate = new Point3D(0, 0, 0);
		stateChanged = true;
		notifyObserver();
		return currentCoordinate;
	}
	
	// Getters & Setters

	/**
	 * @return the currentSpeed
	 */
	public double getCurrentSpeed() {
		return currentSpeed;
	}

	/**
	 * @param currentSpeed the currentSpeed to set
	 */
	public void setCurrentSpeed(double currentSpeed) {
		this.currentSpeed = currentSpeed;
		stateChanged = true;
		notifyObserver();
	}

	/**
	 * @return the noseConeAngle
	 */
	public double getNoseConeAngle() {
		return noseConeAngle;
	}

	/**
	 * @param noseConeAngle the noseConeAngle to set
	 */
	public void setNoseConeAngle(double noseConeAngle) {
		this.noseConeAngle = noseConeAngle;
		stateChanged = true;
		notifyObserver();
	}

	/**
	 * @return the currentCoordinate
	 */
	public Point3D getCurrentCoordinate() {
		return currentCoordinate;
	}

	/**
	 * @param currentCoordinate the currentCoordinate to set
	 */
	public void setCurrentCoordinate(Point3D currentCoordinate) {
		this.currentCoordinate = currentCoordinate;
		stateChanged = true;
		notifyObserver();
	}

	/**
	 * @return the targetCoordinate
	 */
	public Point3D getTargetCoordinate() {
		return targetCoordinate;
	}

	/**
	 * @param targetCoordinate the targetCoordinate to set
	 */
	public void setTargetCoordinate(Point3D targetCoordinate) {
		this.targetCoordinate = targetCoordinate;
		stateChanged = true;
		notifyObserver();
	}

	/**
	 * @return the surroundings
	 */
	public List<Surroundings> getSurroundings() {
		return surroundings;
	}

	/**
	 * @param surroundings the surroundings to set
	 */
	public void setSurroundings(List<Surroundings> surroundings) {
		this.surroundings = surroundings;
		stateChanged = true;
		notifyObserver();
		
	}

	/**
	 * @return the possibleRoutes
	 */
	public List<Route> getPossibleRoutes() {
		return possibleRoutes;
	}

	/**
	 * @param possibleRoutes the possibleRoutes to set
	 */
	public void setPossibleRoutes(List<Route> possibleRoutes) {
		this.possibleRoutes = possibleRoutes;
		stateChanged = true;
		notifyObserver();
	}

	/**
	 * @return the bestRoute
	 */
	public Route getBestRoute() {
		return bestRoute;
	}

	/**
	 * @param bestRoute the bestRoute to set
	 */
	public void setBestRoute(Route bestRoute) {
		this.bestRoute = bestRoute;
		stateChanged = true;
		notifyObserver();
	}

	/**
	 * @return the currentRoute
	 */
	public Route getCurrentRoute() {
		return currentRoute;
	}

	/**
	 * @param currentRoute the currentRoute to set
	 */
	public void setCurrentRoute(Route currentRoute) {
		this.currentRoute = currentRoute;
		stateChanged = true;
		notifyObserver();
	}

	/**
	 * @return the onCourse
	 */
	public boolean isOnCourse() {
		return onCourse;
	}

	/**
	 * @param onCourse the onCourse to set
	 */
	public void setOnCourse(boolean onCourse) {
		this.onCourse = onCourse;
		stateChanged = true;
		notifyObserver();
	}
	
	public boolean isOnAutopilot() {
		return onAutopilot;
	}
	
	public void setOnAutopilot(boolean onAutopilot) {
		this.onAutopilot = onAutopilot;
	}

	@Override
	public void register(Observer observer) {
		observerList.add(observer);
	}

	@Override
	public void remove(Observer observer) {
		observerList.remove(observer);
	}

	@Override
	public Object getUpdate() {
		Object changedState = null;
		if(stateChanged) {
			changedState = "";
		}
		return changedState;
	}

	@Override
	public void notifyObserver() {
		if(stateChanged) {
			for(Observer o : observerList) {
				o.update();
			}
		}
	}

}
