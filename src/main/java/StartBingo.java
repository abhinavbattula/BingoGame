import java.util.*;

public class StartBingo {

    public static void main(String args[]) {
        Scanner inputData = new Scanner(System.in);

        System.out.println("**** Let's Play Housie *****");
        System.out.println();
        System.out.println("Note: - Press 'Q' to quit any time.");
        System.out.println();

        System.out.print("Enter Number of players playing the game.: ");
        int playerCount = inputData.nextInt();

        System.out.print("Enter Ticket Size-Rows or Enter 0 for default to 3: ");
        int enteredRow = inputData.nextInt();
        int cardRows = 3;
        if (enteredRow != 0) {
            cardRows = enteredRow;
        }


        System.out.print("Enter Ticket Size-Columns or Enter 0 for default to 10: ");
        int enteredColumn = inputData.nextInt();
        int cardColumns = 10;
        if (enteredColumn != 0) {
            cardColumns = enteredColumn;
        }

        System.out.print("Enter the number range(1-n): ");
        int numberUpperRange = inputData.nextInt();

        while (numberUpperRange < cardColumns * cardRows) {

            System.out.print("Number upper range should be greater than cardRows * cardColumns");
            System.out.print("Enter number Upper Range again: ");
            numberUpperRange = inputData.nextInt();
        }

        int numberLowerRange = 1;

        System.out.print("Enter numbers per row: ");
        int numbersPerRow = inputData.nextInt();

        while (numbersPerRow > cardColumns) {
            System.out.print("Numbers per row cannot be more than columns: ");
            System.out.print("Enter numbers per row again: ");
            numbersPerRow = inputData.nextInt();
        }

        simulateGame(inputData, playerCount, cardRows, cardColumns, numberUpperRange, numberLowerRange, numbersPerRow);

    }

    private static void simulateGame(Scanner inputData, int playerCount, int cardRows, int cardColumns, int numberUpperRange, int numberLowerRange, int numbersPerRow) {

        Play play = new Play();
        GameDetails gameDetails = play.cardCreator(playerCount, cardRows, cardColumns, numbersPerRow, numberLowerRange, numberUpperRange);

        System.out.println("***Ticket Created Successfully ****\n" +
                ">> Press 'N' to generate next number.");

        String input = inputData.nextLine();
        Random rand = new Random();
        int number = 0;
        Set<Integer> seenNumbers = new HashSet<>();
        while (!Utils.checkGameStatus()) {
            input = inputData.nextLine();
            if (input.equals("Q")) {
                Utils.setTerminateGame(Boolean.TRUE);
                break;
            }
            if (input.equals("N")) {
                int random = rand.nextInt(numberUpperRange) + 1;

                if (seenNumbers.contains(random)) {
                    while (seenNumbers.contains(random)) {
                        random = rand.nextInt(numberUpperRange) + 1;
                    }
                    seenNumbers.add(random);
                    number = random;
                } else {
                    number = random;
                    seenNumbers.add(number);
                }
            }
            System.out.println("Next number is: " + number);
            for (int i = 1; i <= playerCount; i++) {
                play.playGame(gameDetails, gameDetails.getPlayerDetails().get(i), number);
            }
        }

        if (!Utils.isTerminateGame()) {
            System.out.println("Game over");
            System.out.println("Summery:");
            gameDetails.getSummery().forEach((player, s) -> System.out.println("Player#" + player.getId() + " : " + s));
        } else {
            System.out.println("Game Terminated");
        }
    }

}
