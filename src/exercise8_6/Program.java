package exercise8_6;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Objects;

import common.Day;
import common.NullShow;
import common.Show;

/**
 * Exercise 8.6: Observable Program using the Push data-flow strategy with a single observer interface.
 */
public class Program {

	private final EnumMap<Day, Show> aShows = new EnumMap<>(Day.class);
	private final List<ProgramObserver> aObservers = new ArrayList<>();

	public Program() {
		for (Day day : Day.values()) {
			aShows.put(day, NullShow.getInstance());
		}
	}

	public void addObserver(ProgramObserver pObserver) {
		if (pObserver != null && !aObservers.contains(pObserver)) {
			aObservers.add(pObserver);
		}
	}

	public void removeObserver(ProgramObserver pObserver) {
		aObservers.remove(pObserver);
	}

	/**
	 * Adds a show to a specified day and pushes notification to observers.
	 */
	public void add(Day pDay, Show pShow) {
		Objects.requireNonNull(pDay, "Day cannot be null");
		Objects.requireNonNull(pShow, "Show cannot be null");

		aShows.put(pDay, pShow);

		// PUSH: Directly pass the event payload to all registered observers
		for (ProgramObserver obs : aObservers) {
			obs.showAdded(pDay, pShow);
		}
	}

	/**
	 * Removes a show from a specified day and pushes notification to observers.
	 */
	public void remove(Day pDay) {
		Objects.requireNonNull(pDay, "Day cannot be null");

		Show existing = aShows.get(pDay);
		if (existing != null && !existing.equals(NullShow.getInstance())) {
			aShows.put(pDay, NullShow.getInstance());

			// PUSH: Notify observers of removal event with the removed show details
			for (ProgramObserver obs : aObservers) {
				obs.showRemoved(pDay, existing);
			}
		}
	}

	/**
	 * Clears the entire program and notifies observers.
	 */
	public void clear() {
		for (Day day : Day.values()) {
			aShows.put(day, NullShow.getInstance());
		}

		// PUSH: Notify observers of program clear
		for (ProgramObserver obs : aObservers) {
			obs.programCleared();
		}
	}

	public Show get(Day pDay) {
		Objects.requireNonNull(pDay);
		return aShows.get(pDay);
	}

	public boolean hasShow(Day pDay) {
		return !get(pDay).equals(NullShow.getInstance());
	}

	public int count() {
		int count = 0;
		for (Day day : Day.values()) {
			if (hasShow(day)) count++;
		}
		return count;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("=== Program Schedule (Push) ===\n");
		for (Day day : Day.values()) {
			sb.append(String.format("  %-10s : %s%n", day.name(), get(day).description()));
		}
		return sb.toString();
	}
}
