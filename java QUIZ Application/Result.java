public class Result {

    private String playerName;
    private int score;
    private int totalQuestions;

    public Result(String playerName, int score, int totalQuestions) {
        this.playerName = playerName;
        this.score = score;
        this.totalQuestions = totalQuestions;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getScore() {
        return score;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public int getPercentage() {
        return (score * 100) / totalQuestions;
    }
}
