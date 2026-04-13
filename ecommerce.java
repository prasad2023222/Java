import java.util.*;

class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

class CartItem {
    Product product;
    int quantity;

    CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    double getTotal() {
        return product.price * quantity;
    }
}

public class EcommerceSystem {

    static HashMap<Integer, Product> store = new HashMap<>();
    static ArrayList<CartItem> cart = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add product to store
    static void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        store.put(id, new Product(id, name, price));
        System.out.println("Product Added!");
    }

    // View all products
    static void viewProducts() {
        System.out.println("\nAvailable Products:");
        for (Product p : store.values()) {
            System.out.println(p.id + " | " + p.name + " | ₹" + p.price);
        }
    }

    // Add to cart
    static void addToCart() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        if (!store.containsKey(id)) {
            System.out.println("Product not found!");
            return;
        }

        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        Product p = store.get(id);

        // check if already in cart
        for (CartItem item : cart) {
            if (item.product.id == id) {
                item.quantity += qty;
                System.out.println("Quantity updated in cart!");
                return;
            }
        }

        cart.add(new CartItem(p, qty));
        System.out.println("Added to cart!");
    }

    // View cart
    static void viewCart() {
        System.out.println("\nYour Cart:");
        double total = 0;

        for (CartItem item : cart) {
            System.out.println(item.product.name + 
                " x " + item.quantity + 
                " = ₹" + item.getTotal());
            total += item.getTotal();
        }

        System.out.println("Total: ₹" + total);
    }

    // Remove item from cart
    static void removeFromCart() {
        System.out.print("Enter Product ID to remove: ");
        int id = sc.nextInt();

        cart.removeIf(item -> item.product.id == id);
        System.out.println("Item removed!");
    }

    // Checkout
    static void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }

        System.out.println("\n===== BILL =====");
        double total = 0;

        for (CartItem item : cart) {
            System.out.println(item.product.name + 
                " x " + item.quantity + 
                " = ₹" + item.getTotal());
            total += item.getTotal();
        }

        double tax = total * 0.05;
        double finalAmount = total + tax;

        System.out.println("---------------------");
        System.out.println("Subtotal: ₹" + total);
        System.out.println("Tax (5%): ₹" + tax);
        System.out.println("Final Amount: ₹" + finalAmount);

        cart.clear();
        System.out.println("Order Placed Successfully!");
    }

    public static void main(String[] args) {

        // Preload some products
        store.put(1, new Product(1, "Laptop", 50000));
        store.put(2, new Product(2, "Phone", 20000));
        store.put(3, new Product(3, "Headphones", 2000));

        while (true) {
            System.out.println("\n=== E-COMMERCE SYSTEM ===");
            System.out.println("1.Add Product");
            System.out.println("2.View Products");
            System.out.println("3.Add to Cart");
            System.out.println("4.View Cart");
            System.out.println("5.Remove from Cart");
            System.out.println("6.Checkout");
            System.out.println("7.Exit");

            int ch = sc.nextInt();

            switch (ch) {
                case 1: addProduct(); break;
                case 2: viewProducts(); break;
                case 3: addToCart(); break;
                case 4: viewCart(); break;
                case 5: removeFromCart(); break;
                case 6: checkout(); break;
                case 7: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }
}
