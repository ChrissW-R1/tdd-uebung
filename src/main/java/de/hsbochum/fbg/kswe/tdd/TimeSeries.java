package de.hsbochum.fbg.kswe.tdd;

import java.util.HashSet;
import java.util.Set;

import de.hsbochum.solarcar.units.geometry.length.LengthUnit;
import de.hsbochum.solarcar.units.geometry.length.Meter;
import lombok.Getter;

public class TimeSeries {
	@Getter
	private final String name;
	
	private Set<Observation> observations = new HashSet<>();
	
	public TimeSeries(String name) {
		this.name = name;
	}
	
	public Set<Observation> getObservations() {
		return new HashSet<>(this.observations);
	}
	
	public boolean addObservation(Observation observation) {
		return this.observations.add(observation);
	}
	
	public boolean removeObservation(Observation observation) {
		return this.observations.remove(observation);
	}
	
	public double calculateMean(LengthUnit unit) {
		return this.observations.stream().mapToDouble(value -> value.getValue().convertTo(unit).getValue()).average().getAsDouble();
	}
	
	public double calculateMean() {
		return this.calculateMean(new Meter());
	}
}
