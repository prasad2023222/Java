import java.util.*;

class Product {
    String name;
    int price;
    int qty;

    Product(String n, int p, int q) {
        name = n;
        price = p;
        qty = q;
    }
}

public class InventorySystem {
    static HashMap<String, Product> store = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    static void addProduct() {
        System.out.print("Name Price Qty: ");
        String n = sc.next();
        int p = sc.nextInt();
        int q = sc.nextInt();
        store.put(n, new Product(n, p, q));
    }

    static void buyProduct() {
        System.out.print("Enter product: ");
        String n = sc.next();
        Product p = store.get(n);

        if (p != null && p.qty > 0) {
            p.qty--;
            System.out.println("Bill: " + p.price);
        } else {
            System.out.println("Out of stock");
        }
    }

    static void viewStock() {
        for (Product p : store.values())
            System.out.println(p.name + " " + p.qty);
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("1.Add 2.Buy 3.View 4.Exit");
            int ch = sc.nextInt();

            if (ch == 1) addProduct();
            else if (ch == 2) buyProduct();
            else if (ch == 3) viewStock();
            else break;
        }
    }
}
