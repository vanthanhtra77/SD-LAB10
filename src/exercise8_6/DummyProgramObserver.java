package exercise8_6;

import common.Day;
import common.Show;

/**
 * Exercise 8.6: Concrete dummy observer to test the push Observer pattern application.
 */
public class DummyProgramObserver implements ProgramObserver {

	private final String aName;

	public DummyProgramObserver(String pName) {
		aName = pName;
	}

	@Override
	public void showAdded(Day pDay, Show pShow) {
		System.out.printf("[%s] [PUSH EVENT: ADDED] Day: %-10s | Show: %s (%d mins)%n",
				aName, pDay, pShow.description(), pShow.runningTime());
	}

	@Override
	public void showRemoved(Day pDay, Show pShow) {
		System.out.printf("[%s] [PUSH EVENT: REMOVED] Day: %-10s | Removed Show: %s%n",
				aName, pDay, pShow.description());
	}

	@Override
	public void programCleared() {
		System.out.printf("[%s] [PUSH EVENT: CLEARED] The entire program schedule was cleared.%n", aName);
	}
}
