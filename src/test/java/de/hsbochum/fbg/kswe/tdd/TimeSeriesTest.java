package de.hsbochum.fbg.kswe.tdd;

import de.hsbochum.solarcar.units.UnitPrefix;
import de.hsbochum.solarcar.units.geometry.length.LengthAmount;
import de.hsbochum.solarcar.units.geometry.length.Meter;
import org.hamcrest.CoreMatchers;
import org.hamcrest.number.IsCloseTo;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author <a href="mailto:m.rieke@52north.org">Matthes Rieke</a>
 */
public class TimeSeriesTest {
	@Test
	public void testStatistics() {
		TimeSeries ts = new TimeSeries("waterGauge");
		ts.addObservation(new Observation(12.2, new DateTime("2017-06-06T12:00:00+01:00")));
		ts.addObservation(new Observation(12.4, new DateTime("2017-06-06T12:30:00+01:00")));
		ts.addObservation(new Observation(14.4, new DateTime("2017-06-06T13:00:00+01:00")));
		
		Assert.assertThat(ts.calculateMean(), CoreMatchers.is(13.0));
	}
	
	@Test
	public void testUnits() {
		TimeSeries series = new TimeSeries("distance");
		series.addObservation(new Observation(
				                      new LengthAmount(12.2, new Meter()),
				                      new DateTime("2017-06-07T09:46:37+02:00"))
		                     );
		series.addObservation(new Observation(
				                      new LengthAmount(1240, new Meter(UnitPrefix.CENTI)),
				                      new DateTime("2017-06-07T09:48:10+02:00"))
		                     );
		series.addObservation(new Observation(
				                      new LengthAmount(1.44, new Meter(UnitPrefix.DECA)),
				                      new DateTime("2017-06-07T09:48:57+02:00"))
		                     );
		
		Assert.assertThat(series.calculateMean(new Meter(UnitPrefix.DECI)), IsCloseTo.closeTo(130, 0.0000000001));
	}
}
