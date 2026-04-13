import java.util.*;

class Question {
    String ques;
    String ans;

    Question(String q, String a) {
        ques = q;
        ans = a;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Question> list = new ArrayList<>();
        list.add(new Question("Capital of India?", "Delhi"));
        list.add(new Question("5+5?", "10"));
        list.add(new Question("Java creator?", "James"));

        int score = 0;

        for (Question q : list) {
            System.out.println(q.ques);
            String user = sc.nextLine();

            if (user.equalsIgnoreCase(q.ans)) {
                score++;
            }
        }

        System.out.println("Final Score: " + score);
    }
}
