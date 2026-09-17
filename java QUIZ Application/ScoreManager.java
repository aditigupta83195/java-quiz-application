import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScoreManager {

    private String fileName = "quiz_results.txt";

    public void saveResult(Result result) {

        try {
            FileWriter writer = new FileWriter(fileName, true);

            writer.write("Player: " + result.getPlayerName() + "\n");
            writer.write("Score: " + result.getScore()
                    + " / " + result.getTotalQuestions() + "\n");
            writer.write("Percentage: " + result.getPercentage() + "%\n");
            writer.write("--------------------------\n");

            writer.close();

        } catch (IOException e) {
            System.out.println("Could not save the result.");
        }
    }

    public String getHistory() {

        String history = "";

        try {
            Scanner scanner = new Scanner(
                    new java.io.File(fileName)
            );

            while (scanner.hasNextLine()) {
                history += scanner.nextLine() + "\n";
            }

            scanner.close();

        } catch (Exception e) {
            history = "No score history available.";
        }

        return history;
    }
}
