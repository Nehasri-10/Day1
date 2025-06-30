import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Day4{
    public static void main(String[] args) {
        String filename="notes.txt";
        String text="This is my first note.\nThis is the second note.";
        try (FileWriter writer=new FileWriter(filename)) {
            writer.write(text);
            System.out.println("Notes written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: "+ e.getMessage());
        }
        try (FileReader fr=new FileReader(filename);
             BufferedReader br=new BufferedReader(fr)) {
            String line;
            System.out.println("\nReading notes from file:");
            while ((line=br.readLine()) != null) {
                System.out.println(line); 
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
