import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double minValue = 0;
        double maxValue = 0;
        int loopCount = 0;

        while (true) {
            System.out.println("Hello, please enter a number or Character to Exit");
            String userInput = scanner.nextLine();

            try {
                Double.parseDouble(userInput);
                double userInputToSave = Double.parseDouble(userInput);

                 while (loopCount < 1) {
                    if (userInputToSave <= minValue || userInputToSave >= maxValue) {
                        minValue = userInputToSave;
                        maxValue = userInputToSave;
                        loopCount++;
                    }
                }

                if (minValue > userInputToSave) {
                    minValue = userInputToSave;
                }

                if (maxValue < userInputToSave) {
                    maxValue = userInputToSave;
                }


//                if (userInputToSave >= maxValue) {
//                    maxValue = userInputToSave;
//                }
//
//                if(userInputToSave <= minValue) {
//                    minValue = userInputToSave;
//                }

                System.out.println("Current Min value is " + minValue);
                System.out.println("Current Max value is " + maxValue);

            } catch (NumberFormatException nst) {
                break;
            }

        }


    }

    public static String getInputFromConsole(int currentYear) {

        String name = System.console().readLine("Hi, what's your Name?");
        System.out.println("Hi " + name + ", Thanks for taking the course!");

        String dateOfBirth = System.console().readLine("What year were you born?");
        int age = currentYear - Integer.parseInt(dateOfBirth);

        return "So you are " + age + " years old";
    }

    public static String getInputFromScanner(int currentYear) {
        Scanner scanner = new Scanner(System.in);

//        String name = System.console().readLine("Hi, what's your Name?");
        System.out.println("Hi, what's your Name? ");
        String name = scanner.nextLine();

        System.out.println("Hi " + name + ", Thanks for taking the course!");

//        String dateOfBirth = System.console().readLine("What year were you born?");
        System.out.println("What year were you born? ");

        boolean validDOB = false;
        int age = 0;

        do {
            System.out.println("Enter a year of birth >= " + (currentYear - 125) + " and <= " + (currentYear));

            try {
                age = checkData(currentYear, scanner.nextLine());
                validDOB = age < 0 ? false : true;
            } catch (NumberFormatException badUserData) {
                System.out.println("Characters not allowed!!! Try again.");
            }
        } while(!validDOB);

        return "So you are " + age + " years old";
    }

    public static int checkData(int currentYear, String dateOfBirth) {
        int dob = Integer.parseInt(dateOfBirth);
        int minimumYear = currentYear - 125;

        if ((dob < minimumYear) || (dob > currentYear)) {
            return -1;
        }

        return (currentYear  - dob);
    }
}