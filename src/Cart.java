import java.util.ArrayList;
import java.util.List;

class Cart {
	private final List<CartItem> items = new ArrayList<>();

	public void add(Product product, int quantity) {
		if (!product.isAvailable(quantity)) {
			throw new IllegalArgumentException("Not enough stock for: " + product.getName());
		}
		product.reduceQuantity(quantity);
		items.add(new CartItem(product, quantity));
	}

	public void removeQuantity(int index, int quantityToRemove) {
		if (index < 0 || index >= items.size()) {
			throw new IllegalArgumentException("Invalid cart item index.");
		}

		CartItem item = items.get(index);

		if (quantityToRemove <= 0 || quantityToRemove > item.quantity) {
			throw new IllegalArgumentException("Invalid quantity to remove.");
		}

		item.product.reduceQuantity(-quantityToRemove); // Restore product quantity

		item.quantity -= quantityToRemove;

		if (item.quantity == 0) {
			items.remove(index); // remove from cart if nothing left
		}
	}

	public List<CartItem> getItems() {
		return items;
	}

	public boolean isEmpty() {
		return items.isEmpty();
	}

	public double getSubtotal() {
		return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
	}

	public List<CartItem> getShippableItems() {
		List<CartItem> shippables = new ArrayList<>();
		for (CartItem item : items) {
			if (item.isShippable()) {
				shippables.add(item);
			}
		}
		return shippables;
	}
}