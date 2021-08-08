import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {
    private static boolean fullHouse = Boolean.FALSE;
    private static boolean topLine = Boolean.FALSE;
    private static boolean earlyFive = Boolean.FALSE;
    private static String FULL_HOUSE = "fullHouse";
    private static String EARLY_FIVE_IN_PROGRESS = "earlyFive";
    private static String TOP_LINE = "topLine";
    private static String FULL_HOUSE_IN_PROGRESS = "fullHouseInProgress";
    private static String TOP_LINE_IN_PROGRESS = "topLineInProgress";
    private static String NOTHING_WON = "Nothing";
    private static boolean terminateGame= Boolean.FALSE;

    //computes the full house numbers from the player card
    public static Set<Integer> computeFullHouse(List<List<Integer>> card) {
        Set<Integer> fullHouse = new HashSet();
        for (int i = 0; i < card.size(); i++) {
            for (int j = 0; j < card.get(i).size(); j++) {
                fullHouse.add(card.get(i).get(j));
            }
        }
        return fullHouse;
    }

    //computes the Top line numbers from the player card
    public static Set<Integer> computeTopLine(List<List<Integer>> card) {

        return new HashSet<>(card.get(0));
    }

    //converts the card to list to compute the all possible winning combinations in the later game play
    public static List<List<Integer>> convertToList(int[][] card) {
        List<List<Integer>> convertedCard = new ArrayList<>();
        for (int i = 0; i < card.length; i++) {
            List<Integer> row = new ArrayList();
            for (int j = 0; j < card[i].length; j++) {
                if (card[i][j] != 0) {
                    row.add(card[i][j]);
                }
            }
            convertedCard.add(row);
        }
        return convertedCard;
    }

    public static boolean checkGameStatus() {
        return isFullHouse() && isTopLine() && isEarlyFive();
    }

    public static boolean isFullHouse() {
        return fullHouse;
    }

    public static void setFullHouse(boolean fullHouse) {
        Utils.fullHouse = fullHouse;
    }

    public static boolean isTopLine() {
        return topLine;
    }

    public static void setTopFive(boolean topLine) {
        Utils.topLine = topLine;
    }

    public static boolean isEarlyFive() {
        return earlyFive;
    }

    public static void setEarlyFive(boolean earlyFive) {
        Utils.earlyFive = earlyFive;
    }

    public static void setTopLine(boolean topLine) {
        Utils.topLine = topLine;
    }

    public static String getFullHouse() {
        return FULL_HOUSE;
    }

    public static void setFullHouse(String fullHouse) {
        FULL_HOUSE = fullHouse;
    }

    public static String getEarlyFiveInProgress() {
        return EARLY_FIVE_IN_PROGRESS;
    }

    public static void setEarlyFiveInProgress(String earlyFiveInProgress) {
        EARLY_FIVE_IN_PROGRESS = earlyFiveInProgress;
    }

    public static String getTopLine() {
        return TOP_LINE;
    }

    public static void setTopLine(String topLine) {
        TOP_LINE = topLine;
    }

    public static String getFullHouseInProgress() {
        return FULL_HOUSE_IN_PROGRESS;
    }

    public static void setFullHouseInProgress(String fullHouseInProgress) {
        FULL_HOUSE_IN_PROGRESS = fullHouseInProgress;
    }

    public static String getTopLineInProgress() {
        return TOP_LINE_IN_PROGRESS;
    }

    public static void setTopLineInProgress(String topLineInProgress) {
        TOP_LINE_IN_PROGRESS = topLineInProgress;
    }

    public static String getNothingWon() {
        return NOTHING_WON;
    }

    public static void setNothingWon(String nothingWon) {
        NOTHING_WON = nothingWon;
    }

    public static boolean isTerminateGame() {
        return terminateGame;
    }

    public static void setTerminateGame(boolean terminateGame) {
        Utils.terminateGame = terminateGame;
    }
}
