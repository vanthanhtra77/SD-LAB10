package exercise8_7;

import common.Day;
import common.Show;

/**
 * Exercise 8.7: Read-only interface for Program enforcing Interface Segregation Principle (ISP).
 * Observers can only inspect the state of the Program; mutating methods (add, remove, clear)
 * are excluded to guarantee compile-time immutability from the observer's perspective.
 */
public interface ReadOnlyProgram {

	/**
	 * @param pDay The day to check.
	 * @return The show scheduled on that day.
	 */
	Show get(Day pDay);

	/**
	 * @param pDay The day to check.
	 * @return True if there is a scheduled show (not NullShow).
	 */
	boolean hasShow(Day pDay);

	/**
	 * @return Number of days with scheduled shows.
	 */
	int count();

	/**
	 * @return True if no shows are scheduled.
	 */
	boolean isEmpty();
}
