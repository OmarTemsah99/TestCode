# 🛒 Fawry Rise Journey – Full Stack Development Internship Challenge

This project is a Java-based solution to the **Fawry Quantum Internship Challenge 3**, simulating an e-commerce system with features like product management, cart handling, shipping logistics, and checkout with validations.

---

## ✅ Features

- 📦 Predefined product catalog (e.g., Cheese, TV, ScratchCard)
- 🛒 Add/remove items from cart with quantity support
- ♻️ Partial quantity removal from cart
- ❌ Expired items are rejected at checkout
- 🚚 Shipping fee is added **only** if shippable items exist
- 🧾 Console-based UI with step-by-step interaction

---

## 🧠 Technologies Used

- Java SE (Standard Edition)
- No external libraries
- OOP principles: Inheritance, Abstraction, Interfaces

---

## 🚀 How to Run

### Option 1: Using IntelliJ IDEA

1. Clone or download the project.
2. Open it in IntelliJ IDEA.
3. Navigate to `ECommerceApp.java`.
4. Right-click the file → `Run 'ECommerceApp.main()'`
5. Use the console menu to interact with the app.

### Option 2: Using Terminal / Command Line

> Prerequisite: Ensure **Java is installed** (`java -version`, `javac -version`)

1. Open terminal in the project root directory.
2. Compile all Java files:
   ```bash
   javac src/*.java

3. Run the program
   ```bash
   java -cp src ECommerceApp

