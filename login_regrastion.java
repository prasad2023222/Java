import java.util.*;

public class Main {
    static HashMap<String, String> users = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    static void register() {
        System.out.print("Username: ");
        String u = sc.next();
        System.out.print("Password: ");
        String p = sc.next();
        users.put(u, p);
    }

    static void login() {
        System.out.print("Username: ");
        String u = sc.next();
        System.out.print("Password: ");
        String p = sc.next();

        if(users.containsKey(u) && users.get(u).equals(p))
            System.out.println("Login Success");
        else
            System.out.println("Invalid");
    }

    public static void main(String[] args) {
        register();
        login();
    }
}
