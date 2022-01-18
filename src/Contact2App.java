import util.Input;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Contact2App {
    private final String directory = "data";
    private final String filename = "contacts.txt";

    public Path dataDirectory = Paths.get(directory);
    public Path dataFile = Paths.get(directory, filename);
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

    private static void deleteByName() {
    }

    private static void searchContactByName() {
    }

    private static void addContacts() {
    }

    private static void printContacts() {
    }


    public static void main(String[] args) {

    }


}
