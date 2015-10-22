package Demo;

/**
 * Created by Sean on 9/16/2015.
 */

    import java.util.*;
    public class JimmyJohns {
        enum Sandwich {TUNA, ROASTBEEF, TURKEY, HAM};
        String sw;
        String name;
        int numOf= 0;
        boolean ketchup = false; boolean mustard = false; boolean mayonnaise = false;
        private static Scanner input;

        public static void main(String[] args) {
            input = new Scanner(System.in);

            Sandwich sammich[] = Sandwich.values(); //enum array for sandwich list

            System.out.println("Hello, please enter your name. "); 	//start user input
            String name = input.next();
            System.out.println("Hello " + name + ". Welcome to Jimmy John's. Please select a sandwich or type exit or no to quit.");

            for (Sandwich each: sammich)
                System.out.println(each);

            String userChoice = input.next();

            if (userChoice.equals("tuna"))
                System.out.println("You selected " + userChoice);
            else if (userChoice.equals("ham"))
                System.out.println("You selected " + userChoice);
            else if (userChoice.equals("turkey"))
                System.out.println("You selected " + userChoice);
            else {
                System.out.println("Goodbye");
                System.exit(0);
            }

            System.out.println("How many " + userChoice + " sandwich's would you like (MAX OF 10 ITEMS)?");

            int sandAmount = input.nextInt();

            //create loop with an exit statement

            //sandwich object
            JimmyJohns jobber = new JimmyJohns(userChoice, sandAmount);

            if (sandAmount <= 0)
                jobber.numOf++;
            else if (sandAmount > 10)
                jobber.numOf=10;

            System.out.println(jobber.numOf + " " + jobber.sw + " sandwiches");
            System.out.println("Would you like any condiments? \nKetchup(0) \nMustard(1) \nMayonnaise(2) \nNo thanks(3)? ");

            int condiment = input.nextInt();

            if (condiment==0) {
                jobber.ketchup = true;
                System.out.println("OK " + name + ", final order is " + jobber.numOf + " " + jobber.sw + " sandwiches with ketchup");
            }
            else if(condiment==1) {
                jobber.mustard=true;
                System.out.println("OK " + name + ", final order is " + jobber.numOf + " " + jobber.sw + " sandwiches with mustard.");
            }
            else if(condiment==2) {
                jobber.mayonnaise=true;
                System.out.println("OK " + name + ", final order is " + jobber.numOf + " " + jobber.sw + " sandwiches with mayonnaise.");
            }
            else
                System.out.println("OK " + name + ", final order is " + jobber.numOf + " " + jobber.sw + " sandwiches with no condiments.");
        }

        JimmyJohns(String arg1, int arg2) {
            sw = arg1.toString();
            numOf= arg2;
        }

        //store name
        JimmyJohns(String arg1) {
            name = arg1;
        }
    }


