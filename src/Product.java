import java.util.Date;

// This where we create new product subclasses from the product SuperClass.
// We have interface Shippable and Expirable to be implemented by the subclasses to identify some unique setting to some items.
interface Shippable {
	String getName();

	double getWeight();
}

abstract class Product {
	protected String name;
	protected double price;
	protected int quantity;

	public Product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public boolean isAvailable(int requestedQty) {
		return quantity >= requestedQty;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void reduceQuantity(int qty) {
		quantity -= qty;
	}

	public boolean isExpired() {
		return false;
	}
}

interface Expirable {
	boolean isExpired();
}

// Concrete Products

class Cheese extends Product implements Shippable, Expirable {
	private final double weight;
	private final Date expiryDate;

	public Cheese(String name, double price, int quantity, double weight, Date expiryDate) {
		super(name, price, quantity);
		this.weight = weight;
		this.expiryDate = expiryDate;
	}

	@Override
	public boolean isExpired() {
		return expiryDate.before(new Date());
	}

	@Override
	public double getWeight() {
		return weight;
	}
}

class Biscuits extends Product implements Shippable, Expirable {
	private final double weight;
	private final Date expiryDate;

	public Biscuits(String name, double price, int quantity, double weight, Date expiryDate) {
		super(name, price, quantity);
		this.weight = weight;
		this.expiryDate = expiryDate;
	}

	@Override
	public boolean isExpired() {
		return expiryDate.before(new Date());
	}

	@Override
	public double getWeight() {
		return weight;
	}
}

class TV extends Product implements Shippable {
	private final double weight;

	public TV(String name, double price, int quantity, double weight) {
		super(name, price, quantity);
		this.weight = weight;
	}

	@Override
	public double getWeight() {
		return weight;
	}
}

class Mobile extends Product {
	public Mobile(String name, double price, int quantity) {
		super(name, price, quantity);
	}
}

class ScratchCard extends Product {
	public ScratchCard(String name, double price, int quantity) {
		super(name, price, quantity);
	}
}

class Yogurt extends Product implements Shippable, Expirable {
	private final double weight;
	private final Date expiryDate;

	public Yogurt(String name, double price, int quantity, double weight, Date expiryDate) {
		super(name, price, quantity);
		this.weight = weight;
		this.expiryDate = expiryDate;
	}

	@Override
	public boolean isExpired() {
		return expiryDate.before(new Date());
	}

	@Override
	public double getWeight() {
		return weight;
	}
}