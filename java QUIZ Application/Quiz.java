import java.util.ArrayList;

public class Quiz {

    private ArrayList<Question> questions;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore() {
        score++;
    }
}