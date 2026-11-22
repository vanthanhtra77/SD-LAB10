package exercise8_7;

import common.Day;

/**
 * Exercise 8.7: Observer interface dedicated exclusively to show removal and clearing events.
 * Segregated from addition events according to ISP.
 */
public interface ProgramRemovalObserver {

	/**
	 * Called when a show is removed from the program.
	 *
	 * @param pProgram Read-only reference to the program subject.
	 * @param pDay The day from which the show was removed.
	 */
	void showRemoved(ReadOnlyProgram pProgram, Day pDay);

	/**
	 * Called when the program has been completely cleared.
	 *
	 * @param pProgram Read-only reference to the program subject.
	 */
	void programCleared(ReadOnlyProgram pProgram);
}
