package TrainingKit;

public class TrainPlay {

    public static void main(String[] args) {

        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;

        int highScore;
        highScore = verifyScore(true,score,levelCompleted,bonus);
        System.out.println("Your final score was " + highScore);

        verifyScore(true , 800, 5 , 100);
        verifyScore(true, 10000,8 , 200);

       }

    public static int verifyScore(boolean gameOver,int score, int levelCompleted, int bonus){

         if (gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 2000;

            return finalScore;
        } else {
             return -1;
         }


    }



}
