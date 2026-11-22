package exercise8_7;

import common.Day;

/**
 * Exercise 8.7: Observer interface dedicated exclusively to show addition events.
 * Uses Pull strategy: receives ReadOnlyProgram and Day, and pulls show data via program.get(day).
 */
public interface ProgramAdditionObserver {

	/**
	 * Called when a show is added to the program.
	 *
	 * @param pProgram Read-only reference to the program subject.
	 * @param pDay The day the show was added to.
	 */
	void showAdded(ReadOnlyProgram pProgram, Day pDay);
}
