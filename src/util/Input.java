package util;

import java.util.Scanner;

public class Input {

        private Scanner scanner;

        public Input() {
            this.scanner = new Scanner(System.in);
        }

        public String getString(){
            String userInput =  scanner.nextLine();
            return userInput;
        }

        public String getString(String prompt){
            System.out.println(prompt);
            return scanner.nextLine();
        }


        public int getInt(){
            try{
                return Integer.parseInt(this.getString());
            } catch(NumberFormatException nfe){
                //nfe.printStackTrace();
                System.out.println("This is not a integer. Please enter a Integer!");
            }
            return getInt();
        }


        public int getInt(String prompt, int min, int max){
            System.out.println(prompt);
            int userInput = scanner.nextInt();

            try{
                if(userInput < min && userInput > max) {
                    return Integer.parseInt(this.getString());
                }
            } catch(NumberFormatException nfe){
                //nfe.printStackTrace();
                System.out.printf("Number is not between %d and %d. Please enter a correct number! %n", min, max);
                return getInt(prompt, min, max);
            }
            return userInput;
        }

}
