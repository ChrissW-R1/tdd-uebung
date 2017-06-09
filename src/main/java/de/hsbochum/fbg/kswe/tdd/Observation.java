package de.hsbochum.fbg.kswe.tdd;

import de.hsbochum.solarcar.units.geometry.length.LengthAmount;
import de.hsbochum.solarcar.units.geometry.length.Meter;
import lombok.Getter;
import org.joda.time.DateTime;

public class Observation {
	@Getter
	private final LengthAmount value;
	@Getter
	private final DateTime     time;
	
	public Observation(LengthAmount value, DateTime time) {
		this.value = value;
		this.time = time;
	}
	
	public Observation(double value, DateTime time) {
		this.value = new LengthAmount(value, new Meter());
		this.time = time;
	}
}
