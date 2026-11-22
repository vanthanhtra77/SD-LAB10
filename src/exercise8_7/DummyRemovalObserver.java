package exercise8_7;

import common.Day;

/**
 * Concrete observer monitoring only removal and clear events (ISP compliant).
 */
public class DummyRemovalObserver implements ProgramRemovalObserver {

	private final String aName;

	public DummyRemovalObserver(String pName) {
		aName = pName;
	}

	@Override
	public void showRemoved(ReadOnlyProgram pProgram, Day pDay) {
		System.out.printf("[%s] [PULL EVENT: REMOVED] Show cleared from %s (Remaining Shows: %d)%n",
				aName, pDay, pProgram.count());
	}

	@Override
	public void programCleared(ReadOnlyProgram pProgram) {
		System.out.printf("[%s] [PULL EVENT: CLEARED] Program is empty? %b (Remaining: %d)%n",
				aName, pProgram.isEmpty(), pProgram.count());
	}
}
