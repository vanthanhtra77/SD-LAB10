package exercise8_6;

import common.Concert;
import common.Day;
import common.Movie;

/**
 * Demo runner for Exercise 8.6.
 */
public class Exercise86Demo {

	public static void main(String[] args) {
		System.out.println("============================================================");
		System.out.println("   DEMO EXERCISE 8.6: OBSERVER PATTERN (PUSH DATA-FLOW)     ");
		System.out.println("============================================================\n");

		Program program = new Program();

		// Create dummy observers
		DummyProgramObserver logger1 = new DummyProgramObserver("MainLogger");
		DummyProgramObserver logger2 = new DummyProgramObserver("BackupLogger");

		program.addObserver(logger1);
		program.addObserver(logger2);

		System.out.println(">> 1. Adding shows to program...");
		program.add(Day.FRIDAY, new Movie("Inception", 2010, 148));
		program.add(Day.SATURDAY, new Concert("Coldplay", "Music of the Spheres", 120));
		program.add(Day.SUNDAY, new Movie("Interstellar", 2014, 169));

		System.out.println("\n>> 2. Current Program State:");
		System.out.print(program);

		System.out.println(">> 3. Removing show on Saturday...");
		program.remove(Day.SATURDAY);

		System.out.println("\n>> 4. Clearing entire schedule...");
		program.clear();

		System.out.println("\n>> 5. Program State after clear:");
		System.out.print(program);
	}
}
