import java.util.*;

public class GameDetails {

    private Map<Player, List<List<Integer>>> cardMap = new HashMap(); //Contains all the player cards
    private Map<Player, Map<String, Set<Integer>>> playerProgress = new HashMap<>();//Contains all the players game progress
    private Map<Integer, Player> playerDetails = new HashMap<>();//maps the player details to player numbers
    private Map<Player,String> summery = new HashMap<>(); // contains all the game summery

    public Map<Player, List<List<Integer>>> getCardMap() {
        return cardMap;
    }

    public void setCardMap(Map<Player, List<List<Integer>>> cardMap) {
        this.cardMap = cardMap;
    }

    public Map<Player, Map<String, Set<Integer>>> getPlayerProgress() {
        return playerProgress;
    }

    public void setPlayerProgress(Map<Player, Map<String, Set<Integer>>> playerProgress) {
        this.playerProgress = playerProgress;
    }

    public Map<Integer, Player> getPlayerDetails() {
        return playerDetails;
    }

    public void setPlayerDetails(Map<Integer, Player> playerDetails) {
        this.playerDetails = playerDetails;
    }

    public Map<Player, String> getSummery() {
        return summery;
    }

    public void setSummery(Map<Player, String> summery) {
        this.summery = summery;
    }
}
