import java.util.List;

class CheckoutService {
	private static final double SHIPPING_FEE = 30;

	public static void checkout(Customer customer, Cart cart) {
		if (cart.isEmpty()) {
			throw new RuntimeException("Cart is empty!");
		}

		for (CartItem item : cart.getItems()) {
			if (item.product instanceof Expirable && ((Expirable) item.product).isExpired()) {
				throw new RuntimeException("Product expired: " + item.product.getName());
			}
		}

		double subtotal = cart.getSubtotal();
		List<CartItem> shippables = cart.getShippableItems();
		boolean hasShipping = !shippables.isEmpty();

		double shippingFee = hasShipping ? SHIPPING_FEE : 0;
		double total = subtotal + shippingFee;

		if (!customer.canAfford(total)) {
			throw new RuntimeException("Insufficient balance!");
		}

		// Reduce product quantities
		for (CartItem item : cart.getItems()) {
			item.product.reduceQuantity(item.quantity);
		}

		// Ship if needed
		if (hasShipping) {
			ShippingService.ship(shippables);
		}

		customer.deduct(total);

		System.out.println("\n** Checkout receipt **");
		for (CartItem item : cart.getItems()) {
			System.out.printf("%dx %-12s %.0f\n", item.quantity, item.getName(), item.getTotalPrice());
		}
		System.out.println("----------------------");
		System.out.printf("Subtotal         %.0f\n", subtotal);
		if (hasShipping) {
			System.out.printf("Shipping         %.0f\n", shippingFee);
		}
		System.out.printf("Amount           %.0f\n", total);
		System.out.printf("Remaining Balance %.0f\n", customer.getBalance());
	}
}
