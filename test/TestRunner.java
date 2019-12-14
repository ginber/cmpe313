import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import utilities.RouteTest;

public class TestRunner {
	
	public static void main(String[] args) {
		
		Result result = JUnitCore.runClasses(RouteTest.class); // run tests in {@code RouteTest} class
		
		// print out test failures
		for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
			
	      System.out.println(result.wasSuccessful()); // print out whether all tests were successful or not
		
	}

}
