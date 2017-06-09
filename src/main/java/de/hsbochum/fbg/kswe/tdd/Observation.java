package de.hsbochum.fbg.kswe.tdd;

import lombok.Getter;
import org.joda.time.DateTime;

public class Observation {
	@Getter
	private final double   value;
	@Getter
	private final DateTime time;
	
	public Observation(double value, DateTime time) {
		this.value = value;
		this.time = time;
	}
}
