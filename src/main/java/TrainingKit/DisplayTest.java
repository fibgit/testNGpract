package TrainingKit;

public class DisplayTest {

    public static void main(String[] args) {

        int positionOnTable = calculateHighScorePosition(1500);
        displayHighScorePosition("Paul",positionOnTable);

        positionOnTable = calculateHighScorePosition(900);
        displayHighScorePosition("John",positionOnTable);

        positionOnTable = calculateHighScorePosition(400);
        displayHighScorePosition("Peter",positionOnTable);

        positionOnTable = calculateHighScorePosition(50);
        displayHighScorePosition("James",positionOnTable);

        positionOnTable = calculateHighScorePosition( 1000);
        displayHighScorePosition("Bug",positionOnTable);

        positionOnTable = calculateHighScorePosition( 2500);
        displayHighScorePosition("Bug",positionOnTable);

    }

//    String playerName;
//    int positionOnTable;
//    int score;
//    int playerScore;

    private static void displayHighScorePosition (String playerName,int positionOnTable) {
        System.out.println(playerName + " managed to get to  position  " + positionOnTable + " on the high score table");
    }

    private static int calculateHighScorePosition (int playerScore) {

         if (playerScore >= 1000) {
            return 1;
        } else if (playerScore >= 500) {
            return 2;
        } else if (playerScore >= 100) {
            return 3;
        } else {
            return 4;
        }

    }

}

