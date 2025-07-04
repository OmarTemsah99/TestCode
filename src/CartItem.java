class CartItem {
	Product product;
	int quantity;

	public CartItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return product.getPrice() * quantity;
	}

	public boolean isShippable() {
		return product instanceof Shippable;
	}

	public double getWeight() {
		if (product instanceof Shippable) {
			return ((Shippable) product).getWeight() * quantity;
		}
		return 0;
	}

	public String getName() {
		return product.getName();
	}
}