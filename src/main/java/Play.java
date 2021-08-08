import java.util.*;

public class Play {

    //used to create the card for each player
    public GameDetails cardCreator(int playerCount, int cardRows, int cardColumns, int numbersPerRow, int numberLowerRange, int numberUpperRange) {

        GeneratePlayerCard bingo = new GeneratePlayerCard();
        GameDetails gameDetails = new GameDetails();

        for (int i = 1; i <= playerCount; i++) {
            Player player = new Player(i);
            gameDetails.getPlayerDetails().put(i, player);
            gameDetails.getSummery().put(player,null);
            int[][] card = bingo.generateCardIntegerArray(cardRows, cardColumns, numbersPerRow - 1, numberLowerRange, numberUpperRange);
            printPlayerCard(card,player.getId());
            calculateWinningCombinations(gameDetails, player, card);
        }
        return gameDetails;
    }

    //used to compute the each players winning combinations
    private void calculateWinningCombinations(GameDetails gameDetails, Player player, int[][] card) {
        gameDetails.getCardMap().put(player, Utils.convertToList(card));
        HashMap progress = new HashMap();
        progress.put(Utils.getFullHouse(), Utils.computeFullHouse(gameDetails.getCardMap().get(player)));
        progress.put(Utils.getTopLine(), Utils.computeTopLine(gameDetails.getCardMap().get(player)));
        progress.put(Utils.getFullHouseInProgress(), new HashSet<>());
        progress.put(Utils.getEarlyFiveInProgress(), new HashSet<>());
        progress.put(Utils.getTopLineInProgress(), new HashSet<>());
        gameDetails.getPlayerProgress().put(player, progress);
    }

    public void playGame(GameDetails gameDetails, Player player, int input) {

        if (gameDetails.getPlayerProgress().get(player).get(Utils.getFullHouse()).contains(input)) {
            gameDetails.getPlayerProgress().get(player).get(Utils.getFullHouseInProgress()).add(input);
            gameDetails.getPlayerProgress().get(player).get(Utils.getEarlyFiveInProgress()).add(input);
        }

        if (gameDetails.getPlayerProgress().get(player).get(Utils.getTopLine()).contains(input)) {
            gameDetails.getPlayerProgress().get(player).get(Utils.getTopLineInProgress()).add(input);
        }

        if (gameDetails.getPlayerProgress().get(player).get(Utils.getEarlyFiveInProgress()).size() == 5 && !Utils.isEarlyFive()) {
            System.out.println("We have a winner: Player#"+player.getId()+" has won 'First Five' winning combination.");
            if(gameDetails.getSummery().get(player)!=null) {
                gameDetails.getSummery().put(player,gameDetails.getSummery().get(player)+ " and First Five");
            }
            else{
                gameDetails.getSummery().put(player, "First Five");
            }
            Utils.setEarlyFive(Boolean.TRUE);
        }

        if (gameDetails.getPlayerProgress().get(player).get(Utils.getTopLineInProgress()).size() == gameDetails.getPlayerProgress().get(player).get(Utils.getTopLine()).size() && !Utils.isTopLine()) {
            System.out.println("We have a winner: Player#"+player.getId()+" has won 'Top Line' winning combination.");
            if(gameDetails.getSummery().get(player)!=null) {
                gameDetails.getSummery().put(player,gameDetails.getSummery().get(player)+ " and Top Line");
            }
            else{
                gameDetails.getSummery().put(player, "Top Line");
            }
            Utils.setTopFive(Boolean.TRUE);
        }

        if (gameDetails.getPlayerProgress().get(player).get(Utils.getFullHouseInProgress()).size() == gameDetails.getPlayerProgress().get(player).get(Utils.getFullHouse()).size() && !Utils.isFullHouse()) {
            System.out.println("We have a winner: Player#"+player.getId()+" has won 'Full House' winning combination.");
            if(gameDetails.getSummery().get(player)!=null) {
                gameDetails.getSummery().put(player,gameDetails.getSummery().get(player)+ " and Full House");
            }
            else{
                gameDetails.getSummery().put(player, "Full House");
            }
            Utils.setFullHouse(Boolean.TRUE);
        }

    }

    private  void printPlayerCard(int[][] card, int player){
        System.out.println("Player#"+player+" Card:");
        System.out.println();
        for(int i=0; i<card.length;i++){
            System.out.print("|");
            for (int j=0; j<card[i].length;j++){
                System.out.print(card[i][j]+", ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println();

    }

}