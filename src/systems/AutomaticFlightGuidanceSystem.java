package systems;

import java.util.ArrayList;
import java.util.List;

import utilities.Point3D;
import utilities.Route;
import utilities.Surroundings;

public class AutomaticFlightGuidanceSystem implements Observer {
	
	// Singleton to prevent multiple object creations
	private static AutomaticFlightGuidanceSystem afgs = new AutomaticFlightGuidanceSystem();

	private AutomaticFlightGuidanceSystem() {
		surroundings = new ArrayList<>();
	}
	
	public static AutomaticFlightGuidanceSystem loadAFGS() {
		return afgs;
	}
	
	
	private Subject navigationSystem;
	private int ETA;
	private Route bestRoute, currentRoute;
	private double speed, angle;
	private Point3D destination;
	private List<Surroundings> surroundings; 
	
	/**
	 * Displays the best route.
	 * @param bestRoute the most optimal route that plane will take
	 */
	public void displayRouteGuidance() {
		System.out.println(bestRoute);
	}
	
	/**
	 * Displays the estimated time arrival.
	 * @param ETA estimated time arrival
	 */
	public void displayETA() {
		System.out.println(ETA);
	}
	
	/**
	 * Calculates the estimated time arrival according to speed and {@code Route}
	 */
	public int calculateETA() {
		return ETA;
	}
	
	/**
	 * Adjusts plane's nose cone angle and speed to help with taking off from the land
	 */
	public void takeOffAid() {
		
	}
	
	/**
	 * Adjusts plane's nose cone angle and speed to help with landing of the plane to the airport
	 */
	public void landingAid() {
		
	}
	
	/**
	 * Activates autopilot.
	 */
	public void activateAutopilot() {
		
	}
	
	/**
	 * Deactivates autopilot.
	 */
	public void deactivateAutopilot() {
		
	}

	@Override
	public void update() {
		String updateString = (String) navigationSystem.getUpdate();
		ETA = Integer.parseInt(updateString.split(" ")[0]);  // for example get the updates like this
	}

	@Override
	public void setSubject(Subject subject) {
		navigationSystem = subject;
	}
	

}
