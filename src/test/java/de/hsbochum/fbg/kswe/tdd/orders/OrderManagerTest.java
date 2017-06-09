package de.hsbochum.fbg.kswe.tdd.orders;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * @author <a href="mailto:m.rieke@52north.org">Matthes Rieke</a>
 */
public class OrderManagerTest {
	private static ProductDeliveryService service;
	private static OrderManager           manager;
	
	@Before
	public void setUp() {
		service = new ProductDeliveryService();
		manager = new OrderManager(service);
	}
	
	@Test
	public void submitOrder() {
		Customer customer = Mockito.mock(Customer.class);
		Product  product  = Mockito.mock(Product.class);
		Order    order    = new Order(customer, 1337, product);
		
		manager.submitOrder(order);
		
		Assert.assertThat(manager.getOrders().iterator().next(), CoreMatchers.is(order));
	}
}
