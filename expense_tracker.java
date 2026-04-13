import java.util.*;

class Expense {
    String category;
    int amount;

    Expense(String c, int a) {
        category = c;
        amount = a;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Expense> list = new ArrayList<>();
        list.add(new Expense("Food", 200));
        list.add(new Expense("Travel", 150));

        HashMap<String, Integer> map = new HashMap<>();

        for(Expense e : list) {
            map.put(e.category, map.getOrDefault(e.category, 0) + e.amount);
        }

        System.out.println(map);
    }
}
