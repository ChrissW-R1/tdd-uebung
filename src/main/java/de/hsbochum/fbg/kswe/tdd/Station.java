package de.hsbochum.fbg.kswe.tdd;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Point;

/**
 * @author <a href="mailto:m.rieke@52north.org">Matthes Rieke</a>
 */
public class Station {
	private Point  location;
	private String name;
	
	public Station(Point location, String name) {
		this.location = location;
		this.name = name;
	}
	
	public Point getLocation() {
		return location;
	}
	
	public void setLocation(Point location) {
		this.location = location;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double distanceTo(Station other) {
		Coordinate thisCoord  = this.getLocation().getCoordinate();
		Coordinate otherCoord = other.getLocation().getCoordinate();
		
		return Math.sqrt(
				Math.pow(thisCoord.getOrdinate(0) - otherCoord.getOrdinate(0), 2)
				+ Math.pow(thisCoord.getOrdinate(1) - otherCoord.getOrdinate(1), 2)
		                );
	}
}
