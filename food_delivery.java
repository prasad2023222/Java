import java.util.*;

class FoodItem {
    int id;
    String name;
    int price;

    FoodItem(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

class CartItem {
    FoodItem item;
    int qty;

    CartItem(FoodItem item, int qty) {
        this.item = item;
        this.qty = qty;
    }

    int total() {
        return item.price * qty;
    }
}

public class FoodDeliveryApp {

    static HashMap<Integer, FoodItem> menu = new HashMap<>();
    static ArrayList<CartItem> cart = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void viewMenu() {
        for (FoodItem f : menu.values()) {
            System.out.println(f.id + " | " + f.name + " | ₹" + f.price);
        }
    }

    static void addToCart() {
        System.out.print("Enter Food ID: ");
        int id = sc.nextInt();

        if (!menu.containsKey(id)) {
            System.out.println("Item not found!");
            return;
        }

        System.out.print("Quantity: ");
        int qty = sc.nextInt();

        for (CartItem c : cart) {
            if (c.item.id == id) {
                c.qty += qty;
                return;
            }
        }

        cart.add(new CartItem(menu.get(id), qty));
    }

    static void viewCart() {
        int total = 0;

        for (CartItem c : cart) {
            System.out.println(c.item.name + " x " + c.qty + " = ₹" + c.total());
            total += c.total();
        }

        System.out.println("Total: ₹" + total);
    }

    static void removeItem() {
        System.out.print("Enter ID to remove: ");
        int id = sc.nextInt();

        cart.removeIf(c -> c.item.id == id);
    }

    static void checkout() {
        int total = 0;

        System.out.println("\n===== BILL =====");
        for (CartItem c : cart) {
            System.out.println(c.item.name + " x " + c.qty + " = ₹" + c.total());
            total += c.total();
        }

        int delivery = 50;
        int finalTotal = total + delivery;

        System.out.println("Delivery: ₹" + delivery);
        System.out.println("Final: ₹" + finalTotal);

        cart.clear();
        System.out.println("Order Placed!");
    }

    public static void main(String[] args) {

        // Preload menu
        menu.put(1, new FoodItem(1, "Burger", 150));
        menu.put(2, new FoodItem(2, "Pizza", 300));
        menu.put(3, new FoodItem(3, "Biryani", 200));

        while (true) {
            System.out.println("\n=== FOOD DELIVERY APP ===");
            System.out.println("1.View Menu");
            System.out.println("2.Add to Cart");
            System.out.println("3.View Cart");
            System.out.println("4.Remove Item");
            System.out.println("5.Checkout");
            System.out.println("6.Exit");

            int ch = sc.nextInt();

            switch (ch) {
                case 1: viewMenu(); break;
                case 2: addToCart(); break;
                case 3: viewCart(); break;
                case 4: removeItem(); break;
                case 5: checkout(); break;
                case 6: return;
                default: System.out.println("Invalid!");
            }
        }
    }
}
