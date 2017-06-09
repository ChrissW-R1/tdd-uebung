package de.hsbochum.fbg.kswe.tdd;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class StationTest {
	@Test
	public void distanceTo() {
		GeometryFactory gf       = new GeometryFactory();
		Station         station1 = new Station(gf.createPoint(new Coordinate(0, 0)), "Station #1");
		Station         station2 = new Station(gf.createPoint(new Coordinate(0, 5)), "Station #2");
		
		Assert.assertThat(station1.distanceTo(station2), CoreMatchers.is(5.0));
	}
}
