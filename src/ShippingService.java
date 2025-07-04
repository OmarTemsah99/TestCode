import java.util.List;

class ShippingService {
	public static void ship(List<CartItem> shippableItems) {
		System.out.println("** Shipment notice **");
		double totalWeight = 0;
		for (CartItem item : shippableItems) {
			double weight = item.getWeight();
			System.out.printf("%dx %-12s %.0fg\n", item.quantity, item.getName(), weight);
			totalWeight += weight;
		}
		System.out.printf("Total package weight %.1fkg\n", totalWeight / 1000);
	}
}