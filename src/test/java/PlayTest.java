import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayTest {

    Play play;

    @Before
    public void setUp() throws Exception {
        play = new Play();
    }

    @Test
    public void testPlayPositive() {

        Play play = new Play();
        GameDetails gameDetails = play.cardCreator(5, 5, 10, 3, 1, 60);
        int j = 1;
        while (j <= 70) {
            for (int i = 1; i <= 5; i++) {
                play.playGame(gameDetails, gameDetails.getPlayerDetails().get(i), j);
            }
            j++;
        }

        Assert.assertTrue(Utils.isEarlyFive());
        Assert.assertTrue(Utils.isTopLine());
        Assert.assertTrue(Utils.isFullHouse());
        Assert.assertTrue(Utils.checkGameStatus());
    }

    @Test
    public void testPlayFirstFivePositive() {
        Play play = new Play();
        GameDetails gameDetails = play.cardCreator(5, 5, 10, 3, 1, 60);
        int j = 0;
        while (j < 60) {
            play.playGame(gameDetails, gameDetails.getPlayerDetails().get(1), j);
            j++;
        }

        Assert.assertTrue(Utils.isEarlyFive());
    }

    @Test
    public void testPlayTopLinePositive() {
        Play play = new Play();
        GameDetails gameDetails = play.cardCreator(5, 5, 10, 3, 1, 60);
        int j = 0;
        while (j < 60) {
            play.playGame(gameDetails, gameDetails.getPlayerDetails().get(1), j);
            j++;
        }
        Assert.assertTrue(Utils.isTopLine());
    }

    @Test
    public void testPlayGamePositive(){
        Play play = new Play();
        GameDetails gameDetails = play.cardCreator(5, 5, 10, 3, 1, 60);
        Assert.assertNotNull(gameDetails);
        Assert.assertNotNull(gameDetails.getCardMap());
        Assert.assertEquals(5, gameDetails.getCardMap().size());
        Assert.assertNotNull(gameDetails.getPlayerProgress());
        Assert.assertNotNull(gameDetails.getPlayerProgress());
    }

}