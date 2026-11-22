package exercise8_7;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Objects;

import common.Day;
import common.NullShow;
import common.Show;

/**
 * Exercise 8.7: Observable Program using Pull data-flow strategy with 2 segregated observer interfaces
 * and enforcing ISP via ReadOnlyProgram.
 */
public class Program implements ReadOnlyProgram {

	private final EnumMap<Day, Show> aShows = new EnumMap<>(Day.class);
	private final List<ProgramAdditionObserver> aAdditionObservers = new ArrayList<>();
	private final List<ProgramRemovalObserver> aRemovalObservers = new ArrayList<>();

	public Program() {
		for (Day day : Day.values()) {
			aShows.put(day, NullShow.getInstance());
		}
	}

	public void addAdditionObserver(ProgramAdditionObserver pObserver) {
		if (pObserver != null && !aAdditionObservers.contains(pObserver)) {
			aAdditionObservers.add(pObserver);
		}
	}

	public void removeAdditionObserver(ProgramAdditionObserver pObserver) {
		aAdditionObservers.remove(pObserver);
	}

	public void addRemovalObserver(ProgramRemovalObserver pObserver) {
		if (pObserver != null && !aRemovalObservers.contains(pObserver)) {
			aRemovalObservers.add(pObserver);
		}
	}

	public void removeRemovalObserver(ProgramRemovalObserver pObserver) {
		aRemovalObservers.remove(pObserver);
	}

	/**
	 * Adds a show to a specified day and notifies addition observers via Pull strategy.
	 */
	public void add(Day pDay, Show pShow) {
		Objects.requireNonNull(pDay, "Day cannot be null");
		Objects.requireNonNull(pShow, "Show cannot be null");

		aShows.put(pDay, pShow);

		// PULL: Pass read-only subject and event key; observer queries what it needs
		for (ProgramAdditionObserver obs : aAdditionObservers) {
			obs.showAdded(this, pDay);
		}
	}

	/**
	 * Removes a show from a specified day and notifies removal observers via Pull strategy.
	 */
	public void remove(Day pDay) {
		Objects.requireNonNull(pDay, "Day cannot be null");

		Show existing = aShows.get(pDay);
		if (existing != null && !existing.equals(NullShow.getInstance())) {
			aShows.put(pDay, NullShow.getInstance());

			// PULL: Pass read-only subject and day to removal observers
			for (ProgramRemovalObserver obs : aRemovalObservers) {
				obs.showRemoved(this, pDay);
			}
		}
	}

	/**
	 * Clears all shows and notifies removal observers via Pull strategy.
	 */
	public void clear() {
		for (Day day : Day.values()) {
			aShows.put(day, NullShow.getInstance());
		}

		// PULL: Pass read-only subject to removal observers
		for (ProgramRemovalObserver obs : aRemovalObservers) {
			obs.programCleared(this);
		}
	}

	// ReadOnlyProgram Implementation (Inspectors only)
	@Override
	public Show get(Day pDay) {
		Objects.requireNonNull(pDay);
		return aShows.get(pDay);
	}

	@Override
	public boolean hasShow(Day pDay) {
		return !get(pDay).equals(NullShow.getInstance());
	}

	@Override
	public int count() {
		int count = 0;
		for (Day day : Day.values()) {
			if (hasShow(day)) count++;
		}
		return count;
	}

	@Override
	public boolean isEmpty() {
		return count() == 0;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("=== Program Schedule (Pull + ISP) ===\n");
		for (Day day : Day.values()) {
			sb.append(String.format("  %-10s : %s%n", day.name(), get(day).description()));
		}
		return sb.toString();
	}
}
