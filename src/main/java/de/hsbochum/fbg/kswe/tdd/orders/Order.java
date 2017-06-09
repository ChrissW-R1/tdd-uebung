package de.hsbochum.fbg.kswe.tdd.orders;

import lombok.Getter;

/**
 * @author <a href="mailto:m.rieke@52north.org">Matthes Rieke</a>
 */
public class Order
		implements Comparable<Order> {
	@Getter
	private final Customer customer;
	@Getter
	private final int      priority;
	@Getter
	private final Product  product;
	
	public Order(Customer customer, int priority, Product product) {
		this.customer = customer;
		this.priority = priority;
		this.product = product;
	}
	
	@Override
	public int compareTo(Order o) {
		return this.getPriority() - o.getPriority();
	}
}
