
package de.hsbochum.fbg.kswe.tdd.orders;

import java.util.*;

/**
 * @author <a href="mailto:m.rieke@52north.org">Matthes Rieke</a>
 */
public class OrderManager {
	private final ProductDeliveryService delivery;
	private final Set<Order> queuedOrders = new LinkedHashSet<>();
	
	public OrderManager(ProductDeliveryService delivery) {
		this.delivery = delivery;
	}
	
	public List<Order> getQueuedOrders() {
		return new LinkedList<>(this.queuedOrders);
	}
	
	public void submitOrder(Order order) {
		this.queuedOrders.add(order);
	}
	
	public void processOrders() {
		List<Order> orders = new LinkedList<>(this.getQueuedOrders());
		Collections.sort(orders);
		
		orders.forEach(order -> {
			this.delivery.deliver(order.getProduct(), order.getCustomer());
			this.queuedOrders.remove(order);
		});
	}
}
