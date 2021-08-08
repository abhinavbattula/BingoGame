import java.util.*;

public class GeneratePlayerCard {

    //generates the bingo card
    public int[][] generateCardIntegerArray(int row, int column, int numbersPerRow, int min, int max) {

        if(max < column * row || numbersPerRow > column){
            return new int[0][0];
        }

        int[][] card = new int[row][column];
        Random rand = new Random();
        Set hashSet = new HashSet();

        //generating an empty card and assigning all the cells with 0
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                card[i][j] = 0;
            }
        }

        for (int i = 0; i < row; i++) {
            int j = 0;
            Set columnSet = new HashSet();
            while (j <= numbersPerRow) {
                int number = rand.nextInt(max) +1 ;
                int randomColumn = rand.nextInt(column);
                if (!hashSet.contains(number) && !columnSet.contains(randomColumn)) {
                    card[i][randomColumn] = number;
                    hashSet.add(number);
                    columnSet.add(randomColumn);
                    j++;
                }
            }
        }
        return card;
    }
}
