
package de.hsbochum.fbg.kswe.tdd.orders;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author <a href="mailto:m.rieke@52north.org">Matthes Rieke</a>
 */
public class OrderManager {
	private final ProductDeliveryService delivery;
	private final List<Order> queuedOrders = new LinkedList<>();
	
	public OrderManager(ProductDeliveryService delivery) {
		this.delivery = delivery;
	}
	
	public Set<Order> getOrders() {
		return new LinkedHashSet<>(this.queuedOrders);
	}
	
	public void submitOrder(Order order) {
		this.queuedOrders.add(order);
	}
}
