import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GeneratePlayerCardTest {

    GeneratePlayerCard card;
    @Before
    public void setUp() throws Exception {
        card = new GeneratePlayerCard();
    }

    @Test
    public void testBingoCardPositive() {
        int[][] bingoCard = card.generateCardIntegerArray(3, 10, 4 - 1, 1, 70 - 1);
        Assert.assertEquals(3, bingoCard.length);
        Assert.assertEquals(10,bingoCard[0].length);
    }

    @Test
    public void testBingoCardInvalidNumbersPerRow(){
        int[][] bingoCard = card.generateCardIntegerArray(3, 3, 4, 1, 70 - 1);
        Assert.assertEquals(0, bingoCard.length);
    }

    @Test
    public void testBingoCardInvalidNumberRange(){
        int[][] bingoCard = card.generateCardIntegerArray(9, 9, 4, 1, 10);
        Assert.assertEquals(0, bingoCard.length);
    }
}
