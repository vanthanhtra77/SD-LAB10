package common;

import java.util.Objects;

/**
 * Represents a live concert show.
 */
public class Concert implements Show {

	private final String aArtist;
	private final String aTitle;
	private final int aRunningTime;

	public Concert(String pArtist, String pTitle, int pTime) {
		assert pArtist != null && pTitle != null && pTime >= 0;
		aArtist = pArtist;
		aTitle = pTitle;
		aRunningTime = pTime;
	}

	public Concert(Concert pConcert) {
		this(pConcert.aArtist, pConcert.aTitle, pConcert.aRunningTime);
	}

	@Override
	public String description() {
		return String.format("%s - %s", aArtist, aTitle);
	}

	@Override
	public int runningTime() {
		return aRunningTime;
	}

	@Override
	public Show copy() {
		return new Concert(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(aArtist, aTitle, aRunningTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Concert other = (Concert) obj;
		return aRunningTime == other.aRunningTime && Objects.equals(aArtist, other.aArtist) && Objects.equals(aTitle, other.aTitle);
	}

	@Override
	public String toString() {
		return description();
	}
}
