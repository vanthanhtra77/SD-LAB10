package exercise8_6;

import common.Day;
import common.Show;

/**
 * Exercise 8.6: Single observer interface using Push data-flow strategy.
 * The subject pushes the relevant data (day, show) directly in the event methods.
 */
public interface ProgramObserver {

	/**
	 * Called when a new show has been added/assigned to a specific day.
	 *
	 * @param pDay The day to which the show was added.
	 * @param pShow The show that was added.
	 */
	default void showAdded(Day pDay, Show pShow) {}

	/**
	 * Called when a show has been removed from a specific day.
	 *
	 * @param pDay The day from which the show was removed.
	 * @param pShow The show that was removed.
	 */
	default void showRemoved(Day pDay, Show pShow) {}

	/**
	 * Called when the entire program schedule has been cleared.
	 */
	default void programCleared() {}
}
