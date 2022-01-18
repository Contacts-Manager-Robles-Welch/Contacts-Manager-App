import util.Input;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ContactApp {
    public static Scanner sc = new Scanner(System.in);

    //Displays Menu Options
    public static void displayMenu() {
        System.out.println("Main Menu");

        System.out.println("1. View All Contacts...");
        System.out.println("2. Add A New Contact...");
        System.out.println("3. Search A Contact By Name...");
        System.out.println("4. Delete An Existing Contact...");
        System.out.println("5. Exit...");

        Input input = new Input();
        //uses util/input method
        int userInput = input.getInt("Enter a number between 1 and 5", 1, 5);

        switch (userInput) {
            case 1:
                printContacts();
                break;
            case 2:
                addContacts();
                break;
            case 3:
                searchContactByName();
                break;
            case 4:
                deleteByName();
                break;
            default:
                System.out.println("Not an Option");
        }
    }


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
            System.out.println();
            displayMenu();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    //Add a new contact
    public static void addContacts(){
        String directory = "data";
        String filename = "contacts.txt";

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        try{
            Input input = new Input();
            String userInputName = input.getString("Enter New Contact Name: ");
            String userInputNumber = input.getString("Enter New Contact Phone Number: ");

            String newContactInfo = userInputName +" | "+ userInputNumber;

            Files.write(dataFile, Arrays.asList(newContactInfo), StandardOpenOption.APPEND);
            System.out.println("Contact Saved!");
            System.out.println();
            displayMenu();

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    //Search Contact by name
    public static void searchContactByName(){
        String directory = "data";
        String filename = "contacts.txt";


        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        try{
            Input input = new Input();
            String userInputName = input.getString("Search Contact By Name: ");
            List<String> contacts = Files.readAllLines(dataFile);
            for(String contact : contacts){
                if(contact.toLowerCase().contains(userInputName.toLowerCase())) {
                    System.out.println(contact);
                }
            }
            System.out.println();
            displayMenu();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    // Delete
    public static void deleteByName(){
        String directory = "data";
        String filename = "contacts.txt";


        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        try{
            Input input = new Input();
            String userInputName = input.getString("Search Contact By Name: ");
            List<String> contacts = Files.readAllLines(dataFile);

            String[] storeDeletedContact; //
            String contactToDelete = ""; //

            for(String contact : contacts){
                storeDeletedContact = contact.split( " | ");

                List<String> deleteContacts = Arrays.asList(storeDeletedContact);

                for(String c : deleteContacts){
                    if(c.toLowerCase().contains(userInputName.toLowerCase())) {
                        contactToDelete = contact;                    }
                }

            }

            contacts.remove(contactToDelete);
            Files.write(dataFile, contacts);
            System.out.println("Deleted: " + contactToDelete);
            System.out.println();
            displayMenu();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        displayMenu();
    }
}
