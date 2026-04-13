import java.util.*;

class Account {
    int accNo;
    double balance;

    Account(int accNo, double balance) {
        this.accNo = accNo;
        this.balance = balance;
    }
}

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Account> map = new HashMap<>();

        map.put(101, new Account(101, 1000));
        map.put(102, new Account(102, 2000));

        map.get(101).balance += 500; // deposit
        map.get(102).balance -= 300; // withdraw

        for(Account a : map.values()) {
            System.out.println(a.accNo + " Balance: " + a.balance);
        }
    }
}
