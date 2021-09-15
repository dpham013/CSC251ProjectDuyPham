
import java.util.Scanner; //Scanner to get user input 

public class Room {
    public static void main(String[] args)
    {
        int choice = 0;// to hold the menu choice
        double roomArea = 0, length = 0, width = 0;
        double BTUs = 0;
        String confirmation = "y";
        String roomName = "";
        int counter = 0;
        Scanner keyboard = new Scanner(System.in);// create a Scanner object to get the user's input

        while (confirmation.equals("y") || confirmation.equals("Y"))
        {

            // asking user input for room length and width.
            System.out.println("\nEnter your room name?");
            roomName = keyboard.nextLine();

            System.out.println("Enter the length of your room (in feet)");
            length = keyboard.nextFloat();
            while (length < 5)
            {
                System.out.print(" Lenght cannot be lower than 5. Please enter again: ");
                length = keyboard.nextFloat();
            }

            System.out.println("Enter the width of your room (in feet)");
            width = keyboard.nextFloat();
            while (width < 5)
            {
                System.out.print("Width cannot be lower than 5. Please enter again: ");
                width = keyboard.nextFloat();
            }

            // Display the Menu
            System.out.println("How much shade the room gets");
            System.out.println("1. Little Shade");
            System.out.println("2. Moderate Shade");
            System.out.println("3. Abundant Shade");

            System.out.print("\nEnter your choice: ");// Ask the user to make a selection from the menu
            choice = keyboard.nextInt();// read in the user's input for the menu selection

            roomArea = calculateArea(width, length);
            String choiceStr = translateShadeChoiceToString(choice);
            BTUs = calculateBTUsPerHour(roomArea, choiceStr);
            displayTitle();
            output( roomName, roomArea, choiceStr, BTUs);
            System.out.println("Would you like to enter another room? Y/N");
            confirmation = keyboard.next();
            keyboard.nextLine();
            counter++;
        }

        System.out.println("The total number of rooms processed was: " + counter);


    }// end main

    public static void displayTitle()
    {
        System.out.println("\nAir Conditioning Window Unit Cooling Capacity\n");
    }

    public static double calculateArea(double width, double length)
    {

        double roomArea = width * length;
        return roomArea;
    }

    public static String translateShadeChoiceToString(int choice)
    {
        // string to hold user choice for display
        String choice1 = "Little Shade";
        String choice2 = "Moderate Shade";
        String choice3 = "Abundant Shade";
        // if else statement for shade BTU multiplier
        if (choice == 1)
        {

            return choice1;
        } else if (choice == 2)
        {

            return choice2;
        } else if (choice == 3)
        {
            return choice3;
        } else
            return "";
    }

    public static double calculateBTUsPerHour(double roomArea, String shade)
    {
        String choice1 = "Little Shade";
        String choice2 = "Moderate Shade";
        String choice3 = "Abundant Shade";
        double BTUsMul = 0;
        double BTUs = 0;
        if (roomArea >= 0 && roomArea < 250)
        {
            BTUs = 5500;
        } else if (roomArea >= 250 && roomArea <= 500)
        {
            BTUs = 10000;
        } else if (roomArea >= 500 && roomArea <= 1000)
        {
            BTUs = 17500;
        } else if (roomArea > 1000)
        {
            BTUs = 24000;
        } else
        {
            System.out.println("invaid input");
        }

        if (shade.equals(choice1))
        {
            BTUsMul = 1.15;
        } else if (shade.equals(choice2))
        {
            BTUsMul = 1;
        } else if (shade.equals(choice3))
        {
            BTUsMul = .9;
        } else
        {
            return 0;
        }
        double totalBTU = BTUs * BTUsMul;
        return totalBTU;
    }

    public static void output(String roomName, double roomArea, String choice, double BTUs)
    {

        System.out.println("Room name: " + roomName);
        System.out.printf("Room Area (in square feet): %.2f feets\n", roomArea);
        System.out.println("Amount of Shade: " + choice);
        System.out.printf("BTU’s Per Hour needed: %.2f", BTUs);
        System.out.println("");

    }
}// end class
