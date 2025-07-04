import java.util.*;

// ------------------- Test Example ------------------------
public class ECommerceApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Product> catalog = new ArrayList<>();
		Cart cart = new Cart();
		Customer customer = new Customer("Omar", 1000); // hardcoded customer

		// Prepare future date for valid (not expired) items
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 10); // 10 days in the future
		Date futureDate = calendar.getTime();

		// Prepare Past date for valid (expired) items
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -5); // 5 days in the past
		Date pastDate = cal.getTime();

		// Hardcoded products
		catalog.add(new Cheese("Cheese", 100, 10, 200, futureDate));
		catalog.add(new Biscuits("Biscuits", 150, 5, 700, futureDate));
		catalog.add(new TV("TV", 5000, 2, 8000));
		catalog.add(new Mobile("Mobile", 4000, 5));
		catalog.add(new ScratchCard("ScratchCard", 50, 10));
		catalog.add(new Yogurt("Yogurt", 40, 20, 100, pastDate));

		// Main Program
		while (true) {
			// Print Menu
			System.out.println("\n==== MENU ====");
			System.out.println("1. View Catalog");
			System.out.println("2. Add Product to Cart");
			System.out.println("3. View Cart");
			System.out.println("4. Remove item from cart");
			System.out.println("5. Checkout");
			System.out.println("6. Exit");


			System.out.print("Choose an option: ");
			int choice = Integer.parseInt(scanner.nextLine());

			// Use Cases
			/*
			 * 1- Shows all the hardcoded products.
			 * 2- add the product number you want to add (so you should check the product catalog first to know which product you want to add)
			 * 3- lets view all the items you add to the cart
			 * 4- allows for removal of items from cart with quantity
			 * 5- if you have enough balance and there is items in the cart it prints the receipt and subtract the amount from the balance
			 * 6- lets you leave the app
			 */
			switch (choice) {
				case 1:
					System.out.println("== Product Catalog ==");
					for (int i = 0; i < catalog.size(); i++) {
						Product p = catalog.get(i);
						System.out.printf("%d. %s | Price: %.2f | Qty: %d\n", i + 1, p.getName(), p.getPrice(), p.getQuantity());
					}
					break;

				case 2:
					System.out.print("Enter product number to add: ");
					int index = Integer.parseInt(scanner.nextLine()) - 1;
					if (index < 0 || index >= catalog.size()) {
						System.out.println("Invalid product.");
						break;
					}

					System.out.print("Enter quantity: ");
					int qty = Integer.parseInt(scanner.nextLine());

					try {
						cart.add(catalog.get(index), qty);
						System.out.println("✅ Added to cart!");
					} catch (Exception e) {
						System.out.println("❌ Error: " + e.getMessage());
					}
					break;

				case 3:
					System.out.println("== Cart Items ==");
					for (CartItem item : cart.getItems()) {
						System.out.printf("%dx %s = %.2f\n", item.quantity, item.getName(), item.getTotalPrice());
					}
					break;

				case 4:
					if (cart.getItems().isEmpty()) {
						System.out.println("Cart is empty.");
						break;
					}

					System.out.println("== Cart Items ==");
					List<CartItem> cartItems = cart.getItems();
					for (int i = 0; i < cartItems.size(); i++) {
						CartItem item = cartItems.get(i);
						System.out.printf("%d. %dx %s = %.2f\n", i + 1, item.quantity, item.getName(), item.getTotalPrice());
					}

					System.out.print("Enter cart item number to remove from: ");
					int removeIndex = Integer.parseInt(scanner.nextLine()) - 1;

					System.out.print("Enter quantity to remove: ");
					int quantityToRemove = Integer.parseInt(scanner.nextLine());

					try {
						cart.removeQuantity(removeIndex, quantityToRemove);
						System.out.println("✅ Removed " + quantityToRemove + " item(s) from cart and restored stock.");
					} catch (Exception e) {
						System.out.println("❌ Error: " + e.getMessage());
					}
					break;

				case 5:
					try {
						CheckoutService.checkout(customer, cart);
					} catch (Exception e) {
						System.out.println("❌ Checkout failed: " + e.getMessage());
					}
					break;

				case 6:
					System.out.println("👋 Exiting. Thanks!");
					return;

				default:
					System.out.println("Invalid option.");
			}
		}
	}
}

