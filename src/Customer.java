class Customer {
	private final String name;
	private double balance;

	public Customer(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}

	public boolean canAfford(double amount) {
		return balance >= amount;
	}

	public void deduct(double amount) {
		balance -= amount;
	}

	public double getBalance() {
		return balance;
	}

	public String getName() {
		return name;
	}
}