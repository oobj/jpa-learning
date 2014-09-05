package br.com.oobj.stateful;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
public class CarrinhoCompras {

	private HashMap<String, Integer> items = new HashMap<String, Integer>();

	public void addItem(String item, int quantity) {
		Integer orderQuantity = items.get(item);
		if (orderQuantity == null) {
			orderQuantity = 0;
		}
		orderQuantity += quantity;
		items.put(item, orderQuantity);
	}

	public void removeItem(String item, int quantity) { }

	public Map<String, Integer> getItems() {
		return items;
	}

	@Remove
	public void checkout(int paymentId) { }

	@Remove
	public void cancel() { }
}
