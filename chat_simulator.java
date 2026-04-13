import java.util.*;

class Message {
    String sender, text;

    Message(String s, String t) {
        sender = s;
        text = t;
    }
}

public class ChatApp {
    public static void main(String[] args) {
        ArrayList<Message> chat = new ArrayList<>();

        chat.add(new Message("User1", "Hello"));
        chat.add(new Message("User2", "Hi"));

        for (Message m : chat)
            System.out.println(m.sender + ": " + m.text);
    }
}
