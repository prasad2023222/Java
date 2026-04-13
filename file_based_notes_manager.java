import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        FileWriter fw = new FileWriter("notes.txt", true);
        System.out.print("Write note: ");
        fw.write(sc.nextLine() + "\n");
        fw.close();

        BufferedReader br = new BufferedReader(new FileReader("notes.txt"));
        String line;

        while((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
}
