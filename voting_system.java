import java.util.*;

class Voter {
    String name;
    boolean voted;

    Voter(String name) {
        this.name = name;
        this.voted = false;
    }
}

public class VotingSystem {
    static HashMap<String, Voter> voters = new HashMap<>();
    static HashMap<String, Integer> votes = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        votes.put("A", 0);
        votes.put("B", 0);

        voters.put("john", new Voter("john"));

        System.out.print("Enter voter name: ");
        String name = sc.next();

        if (voters.containsKey(name)) {
            Voter v = voters.get(name);
            if (!v.voted) {
                System.out.print("Vote A or B: ");
                String choice = sc.next();
                votes.put(choice, votes.get(choice) + 1);
                v.voted = true;
            } else {
                System.out.println("Already voted!");
            }
        }

        System.out.println(votes);
    }
}
