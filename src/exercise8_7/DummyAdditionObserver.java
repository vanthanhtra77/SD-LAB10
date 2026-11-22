package exercise8_7;

import common.Day;
import common.Show;

/**
 * Concrete observer monitoring only addition events (ISP compliant).
 */
public class DummyAdditionObserver implements ProgramAdditionObserver {

	private final String aName;

	public DummyAdditionObserver(String pName) {
		aName = pName;
	}

	@Override
	public void showAdded(ReadOnlyProgram pProgram, Day pDay) {
		// PULL: Actively query the subject using the read-only interface
		Show show = pProgram.get(pDay);
		System.out.printf("[%s] [PULL EVENT: ADDED] Polled Day %s -> %s (Total Active Shows: %d)%n",
				aName, pDay, show.description(), pProgram.count());
	}
}
