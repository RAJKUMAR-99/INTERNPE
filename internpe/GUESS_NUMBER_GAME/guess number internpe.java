import java.util.Scanner;

 class GuessTheNumber {
    private static final int MAX_ATTEMPTS = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Guess the Number Game!");
        System.out.println("I've selected a number between 1 and 100. Can you guess it?");

        int randomNumber = generateRandomNumber();
        boolean hasGuessed = false;

        for (int attempts = 1; attempts <= MAX_ATTEMPTS && !hasGuessed; attempts++) {
            int userGuess = getUserGuess(scanner);

            if (userGuess == randomNumber) {
                hasGuessed = true;
                displaySuccessMessage(randomNumber, attempts);
            } else {
                displayHint(userGuess, randomNumber);
            }
        }

        if (!hasGuessed) {
            System.out.println("Sorry, you've run out of attempts. The correct number was: " + randomNumber);
        }

        scanner.close();
    }

    private static int generateRandomNumber() {
        return (int) (Math.random() * 100) + 1;
    }

    private static int getUserGuess(Scanner scanner) {
        int userGuess = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.print("Enter your guess: ");
                userGuess = scanner.nextInt();
                isValidInput = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        return userGuess;
    }

    private static void displayHint(int userGuess, int randomNumber) {
        if (userGuess < randomNumber) {
            System.out.println("Try a higher number.");
        } else {
            System.out.println("Try a lower number.");
        }
    }

    private static void displaySuccessMessage(int randomNumber, int attempts) {
        System.out.println("Congratulations! You guessed the number " + randomNumber + " in " + attempts + " attempts.");
    }
}
