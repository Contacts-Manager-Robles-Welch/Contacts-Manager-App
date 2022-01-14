package util;

import java.util.Scanner;

public class Input {

        private Scanner scanner;

        //Constructor, have the same name as the class and do not define a return type
        //They can accept arguments and be overloaded.
        public Input() {
            this.scanner = new Scanner(System.in);
        }

        //Class will have the following methods, which all will return command line input from the user
        //String getString(), boolean yesNo(), int getInt(int min, int max), int getInt(), double getDouble(double min, double max), double getDouble()
        public String getString(){
//        System.out.println("Enter Something: ");
            String userInput =  scanner.nextLine();
//        System.out.printf("You entered: %s %n", userInput);
            return userInput;
        }

        public String getString(String prompt){
            System.out.println(prompt);
            return scanner.nextLine();
        }

        public boolean yesNo(){
            System.out.println("Would you like to continue?");
            String userInput = scanner.nextLine();
            if(userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes")){
                return true;
            }else{
                return false;
            }
        }

//    public int getInt(){
//        System.out.println("Enter a whole number: ");
//        int userInput = scanner.nextInt();
//        System.out.printf("You entered %d: ", userInput);
//        return userInput;
//    }

        public int getInt(){
            System.out.println("Enter a Integer: ");
            try{
                return Integer.valueOf(this.getString());
            } catch(NumberFormatException nfe){
//            nfe.printStackTrace();
                System.out.println("This is not a integer. Please enter a Integer!");
                return getInt();
            }
        }

        public int getInt(int min, int max){
            System.out.printf("Enter a number between %d and %d. %n", min, max);
            int userInput = scanner.nextInt();

            if(userInput >= min && userInput <= max){
                return userInput;
            }
            System.out.printf("Number is not between %d and %d. Please enter a correct number! %n", min, max);
            return getInt(min, max);
        }

//    public double getDouble(){
//        System.out.println("Enter a number: ");
//        double userInput = scanner.nextDouble();
//        System.out.printf("You entered %f: ", userInput);
//        return userInput;
//    }

        public double getDouble(){
            System.out.println("Enter a decimal: ");
            try{
                return Double.valueOf(this.getString());
            } catch(NumberFormatException nfe){
//            nfe.printStackTrace();
                System.out.println("This is not a decimal. Please enter a decimal!");
                return getDouble();
            }
        }

        public double getDouble(double min, double max){
            System.out.printf("Enter a number between %f and %f. %n", min, max);
            double userInput = scanner.nextDouble();

            if(userInput >= min && userInput <= max){
                return userInput;
            }
            System.out.printf("Number is not between %f and %f. Please enter a correct number! %n", min, max);
            return getDouble(min, max);
        }

    }
