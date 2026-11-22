package exercise8_7;

import common.Concert;
import common.Day;
import common.Movie;

/**
 * Demo runner for Exercise 8.7.
 */
public class Exercise87Demo {

	public static void main(String[] args) {
		System.out.println("============================================================");
		System.out.println(" DEMO EXERCISE 8.7: PULL STRATEGY & ISP (2 SEGREGATED OBS) ");
		System.out.println("============================================================\n");

		Program program = new Program();

		DummyAdditionObserver addLogger = new DummyAdditionObserver("AddAuditor");
		DummyRemovalObserver removeLogger = new DummyRemovalObserver("RemovalAuditor");

		// Register segregated observers
		program.addAdditionObserver(addLogger);
		program.addRemovalObserver(removeLogger);

		System.out.println(">> 1. Adding shows (Only AdditionObserver receives notification):");
		program.add(Day.MONDAY, new Movie("The Dark Knight", 2008, 152));
		program.add(Day.WEDNESDAY, new Concert("Hans Zimmer", "Live in Prague", 140));

		System.out.println("\n>> 2. Current Program State:");
		System.out.print(program);

		System.out.println(">> 3. Removing show on Monday (Only RemovalObserver receives notification):");
		program.remove(Day.MONDAY);

		System.out.println("\n>> 4. Clearing entire schedule (Only RemovalObserver receives notification):");
		program.clear();

		System.out.println("\n>> 5. Program State after clear:");
		System.out.print(program);
	}
}
