package de.hsbochum.fbg.kswe.tdd.orders;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.hamcrest.collection.IsEmptyCollection;
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
	private static Order[]                orders;
	
	@Before
	public void setUp() {
		service = new ProductDeliveryService();
		manager = new OrderManager(service);
		
		Customer customer = Mockito.mock(Customer.class);
		Product  product  = Mockito.mock(Product.class);
		orders = new Order[] {
				new Order(customer, 1337, product),
				new Order(customer, 1, product),
				new Order(customer, 10, product),
				new Order(customer, 2, product),
				new Order(customer, 5, product)
		};
		
		for (Order order : orders) {
			manager.submitOrder(order);
		}
	}
	
	@Test
	public void sumbitOrder() {
		Order order = Mockito.mock(Order.class);
		
		Assert.assertThat(manager.getQueuedOrders(), CoreMatchers.not(Matchers.hasItem(order)));
		
		manager.submitOrder(order);
		
		Assert.assertThat(manager.getQueuedOrders(), Matchers.hasItem(order));
	}
	
	@Test
	public void getQueuedOrders() {
		int i = 0;
		for (Order order : manager.getQueuedOrders()) {
			Assert.assertThat(order, CoreMatchers.is(orders[i]));
			i++;
		}
	}
	
	@Test
	public void processOrders() {
		manager.processOrders();
		
		Assert.assertThat(manager.getQueuedOrders(), IsEmptyCollection.empty());
	}
}
