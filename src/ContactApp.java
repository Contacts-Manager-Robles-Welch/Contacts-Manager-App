import util.Input;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class ContactApp {
    public static Scanner sc = new Scanner(System.in);

    //Prints contacts to console from contacts.txt
    public static void printContacts(){
        String directory = "data";
        String filename = "contacts.txt";

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        try{
            List<String> contacts = Files.readAllLines(dataFile);
            for(String contact : contacts){
                System.out.println(contact);
            }
//            System.out.println(contacts);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        System.out.println("Main Menu");

        System.out.println("1. View All Contacts...");
        System.out.println("2. Add A New Contact...");
        System.out.println("3. Search A Contact By Name...");
        System.out.println("4. Delete An Existing Contact...");
        System.out.println("5. Exit...");
//        System.out.println("Enter an option 1, 2, 3, 4 or 5");

        Input input = new Input();
        //uses util/input method
        int userInput = input.getInt("Enter a number between 1 and 5", 1, 5);

        switch(userInput){
            case 1:
                printContacts();
                break;
            default:
                System.out.println("Not an Option");
        }
    }
}
