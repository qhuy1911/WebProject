package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<Item> items;
	private int count = 0;
	private double sumPrice;

	public Cart() {
		items = new ArrayList<Item>();
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public int getCount() {
		return items.size();
	}
	
	public double getSumPrice() {
		double sum = 0;
		for (Item item : items) {
			sum += item.getPrice();
		}
		return sum;
	}
}
