public class QuizManager {

    private Quiz quiz;
    private Player player;

    public QuizManager(Player player, Quiz quiz) {
        this.player = player;
        this.quiz = quiz;
    }

    public Player getPlayer() {
        return player;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public boolean isQuizCompleted(int currentQuestion) {
        return currentQuestion >= quiz.getQuestions().size();
    }
}
