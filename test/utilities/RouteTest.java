package utilities;
/**
 * Test class for {@code Route} class
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class RouteTest {
	
	Route route;
	
	/**
	 * Test {@code addCheckPoint} method; test whether a condition is true or not
	 * and boundary conditions
	 */
	@Test
	public void testAddCheckPoint() {
		
		route = new Route();
		
		// whether a condition is true or not
		assertTrue(route.addCheckPoint(new Point3D(1, 1, 1)));  // should fail
		assertTrue(route.addCheckPoint(new Point3D(15, 1, 1)));  // should pass
		
		// boundary conditions
		assertTrue(route.addCheckPoint(new Point3D(4, 1, 1))); // should fail
		assertTrue(route.addCheckPoint(new Point3D(5, 1, 1))); // should fail
		assertTrue(route.addCheckPoint(new Point3D(6, 1, 1))); // should pass

	}
	
	/**
	 * Test whether the target coordinate is identified correctly or not - equality
	 */
	@Test
	public void testTargetCoordinate() {
		
		route = new Route();
		
		// equality
		route.addCheckPoint(new Point3D(6, 0, 0));
		route.addCheckPoint(new Point3D(7, 0, 0));
		assertEquals(7, route.getTargetCoordinate().getX()); // should pass
		route.addCheckPoint(new Point3D(8, 0, 0));
		assertEquals(7, route.getTargetCoordinate().getX()); // should fail
		
	}
	
	/**
	 * Test whether the nearest checkpoint is identified correctly or not - loop testing
	 */
	@Test
	public void testNearestCheckPoint() {
		
		route = new Route();
		
		// ------------------------------ loop testing ------------------------------
		
		assertEquals(null, route.getNearestCheckPoint()); // route is empty, so loop shouldn't execute
		
		route.addCheckPoint(new Point3D(6, 0, 0));
		assertEquals(new Point3D(6, 1, 1), route.getNearestCheckPoint()); // loop should execute only once - fail
		assertEquals(new Point3D(6, 0, 0), route.getNearestCheckPoint()); // loop should execute only once - pass
		
		route = new Route();
		
		route.addCheckPoint(new Point3D(7, 0, 0));
		route.addCheckPoint(new Point3D(6, 0, 0));
		assertEquals(new Point3D(6, 1, 1), route.getNearestCheckPoint()); // loop should execute twice - fail
		assertEquals(new Point3D(6, 0, 0), route.getNearestCheckPoint()); // loop should execute twice - pass
		
		route = new Route();
		route.addCheckPoint(new Point3D(7, 0, 0));
		route.addCheckPoint(new Point3D(8, 0, 0));
		route.addCheckPoint(new Point3D(6, 0, 0));
		route.addCheckPoint(new Point3D(9, 0, 0));
		assertEquals(new Point3D(6, 0, 0), route.getNearestCheckPoint()); // loop should execute 3 times (m times)
		// maximum number of iterations = 4 -> 1 less than maximum number of iterations
		
		route = new Route();
		route.addCheckPoint(new Point3D(7, 0, 0));
		route.addCheckPoint(new Point3D(8, 0, 0));
		route.addCheckPoint(new Point3D(9, 0, 0));
		route.addCheckPoint(new Point3D(6, 0, 0));
		assertEquals(new Point3D(6, 0, 0), route.getNearestCheckPoint()); // loop should execute 4 times (maximum)
		
	}
	

}

