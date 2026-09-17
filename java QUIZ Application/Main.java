import javax.swing.*;
import java.awt.*;


public class Main {

    private static Quiz quiz;
    private static int currentQuestion = 0;
    private static QuizManager quizManager;

  private static JLabel questionLabel;
  private static JLabel progressLabel;
    private static JRadioButton optionA;
    private static JRadioButton optionB;
    private static JRadioButton optionC;
    private static JRadioButton optionD;

    private static ButtonGroup options;
   private static JButton nextButton;
private static String playerName;
private static Player player;
private static Result result;
private static ScoreManager scoreManager = new ScoreManager();
private static TimerManager timerManager = new TimerManager();

private static JLabel timerLabel;
private static Thread timerThread;
private static int timeLeft = 15;
    public static void main(String[] args) {

       quiz = new Quiz();

QuestionManager questionManager = new QuestionManager();

for (Question question : questionManager.getQuestions()) {
    quiz.addQuestion(question);
}

createWindow();
    }

    
    

    // Welcome screen
    public static void createWindow() {

        JFrame frame = new JFrame("Java Quiz Application");

        frame.setSize(650, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
panel.setBackground(new Color(245, 247, 250));

        panel.add(Box.createVerticalStrut(50));

        JLabel title = new JLabel("JAVA QUIZ APPLICATION");
       title.setFont(new Font("Arial", Font.BOLD, 28));
title.setForeground(new Color(45, 45, 45));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(title);

        panel.add(Box.createVerticalStrut(30));

        JLabel welcome = new JLabel("Welcome to the Quiz!");
        welcome.setFont(new Font("Arial", Font.PLAIN, 20));
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(welcome);

        panel.add(Box.createVerticalStrut(25));

        JLabel nameLabel = new JLabel("Enter your name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(nameLabel);

        panel.add(Box.createVerticalStrut(10));

        JTextField nameField = new JTextField();
        nameField.setMaximumSize(new Dimension(300, 35));

        panel.add(nameField);

        panel.add(Box.createVerticalStrut(25));

       JButton startButton = new JButton("START QUIZ");

startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
startButton.setFont(new Font("Arial", Font.BOLD, 15));
startButton.setPreferredSize(new Dimension(160, 40));
startButton.setFocusPainted(false);

        panel.add(startButton);

      startButton.addActionListener(e -> {

    playerName = nameField.getText().trim();

    if (playerName.isEmpty()) {

        JOptionPane.showMessageDialog(
                frame,
                "Please enter your name."
        );

    } else {

        player = new Player(playerName);
        quizManager = new QuizManager(player, quiz);

        frame.dispose();

        createQuizWindow();
    }
});

        frame.add(panel);

        frame.setVisible(true);
    }

    // Quiz screen
    public static void createQuizWindow() {

        JFrame frame = new JFrame("Java Quiz - " + playerName);

        frame.setSize(650, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();

panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
panel.setBackground(new Color(245, 247, 250));

        panel.add(Box.createVerticalStrut(20));

        JLabel title = new JLabel("JAVA QUIZ");

       title.setFont(new Font("Arial", Font.BOLD, 26));
title.setForeground(new Color(45, 45, 45));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(title);

        panel.add(Box.createVerticalStrut(20));

        progressLabel = new JLabel();

progressLabel.setFont(
        new Font("Arial", Font.PLAIN, 16)
);

progressLabel.setAlignmentX(
        Component.CENTER_ALIGNMENT
);

panel.add(progressLabel);

panel.add(Box.createVerticalStrut(10));

questionLabel = new JLabel();

questionLabel.setFont(
        new Font("Arial", Font.BOLD, 18)
);

questionLabel.setForeground(new Color(35, 35, 35));


        questionLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        panel.add(questionLabel);

panel.add(Box.createVerticalStrut(15));

timerLabel = new JLabel("Time left: 15 seconds");
timerLabel.setFont(new Font("Arial", Font.BOLD, 16));
timerLabel.setForeground(new Color(180, 50, 50));
timerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

panel.add(timerLabel);

panel.add(Box.createVerticalStrut(15));

       optionA = new JRadioButton();
optionB = new JRadioButton();
optionC = new JRadioButton();
optionD = new JRadioButton();

optionA.setFont(new Font("Arial", Font.PLAIN, 16));
optionB.setFont(new Font("Arial", Font.PLAIN, 16));
optionC.setFont(new Font("Arial", Font.PLAIN, 16));
optionD.setFont(new Font("Arial", Font.PLAIN, 16));

optionA.setBackground(new Color(245, 247, 250));
optionB.setBackground(new Color(245, 247, 250));
optionC.setBackground(new Color(245, 247, 250));
optionD.setBackground(new Color(245, 247, 250));

        optionA.setAlignmentX(Component.CENTER_ALIGNMENT);
        optionB.setAlignmentX(Component.CENTER_ALIGNMENT);
        optionC.setAlignmentX(Component.CENTER_ALIGNMENT);
        optionD.setAlignmentX(Component.CENTER_ALIGNMENT);

        options = new ButtonGroup();

        options.add(optionA);
        options.add(optionB);
        options.add(optionC);
        options.add(optionD);

        panel.add(optionA);
        panel.add(optionB);
        panel.add(optionC);
        panel.add(optionD);

        panel.add(Box.createVerticalStrut(25));

        nextButton = new JButton("NEXT");

nextButton.setAlignmentX(Component.CENTER_ALIGNMENT);
nextButton.setFont(new Font("Arial", Font.BOLD, 15));
nextButton.setPreferredSize(new Dimension(120, 40));
nextButton.setFocusPainted(false);
        panel.add(nextButton);

        nextButton.addActionListener(
                e -> checkAnswer(frame)
        );

        frame.add(panel);

        showQuestion();
startTimer(frame);

frame.setVisible(true);
    }

    // Showing the current question
    public static void showQuestion() {

        Question q = quiz.getQuestions().get(currentQuestion);
        progressLabel.setText(
        "Question "
        + (currentQuestion + 1)
        + " of "
        + quiz.getQuestions().size()
);

        questionLabel.setText(
                "Question "
                + (currentQuestion + 1)
                + ": "
                + q.getQuestion()
        );

        optionA.setText(
                "A. " + q.getOptionA()
        );

        optionB.setText(
                "B. " + q.getOptionB()
        );

        optionC.setText(
                "C. " + q.getOptionC()
        );

        optionD.setText(
                "D. " + q.getOptionD()
        );

        options.clearSelection();
    }

    // Checking the selected answer
   // Checking the selected answer
public static void checkAnswer(JFrame frame) {

    String selectedAnswer = "";

    if (optionA.isSelected()) {

        selectedAnswer = "A";

    } else if (optionB.isSelected()) {

        selectedAnswer = "B";

    } else if (optionC.isSelected()) {

        selectedAnswer = "C";

    } else if (optionD.isSelected()) {

        selectedAnswer = "D";
    }

    if (selectedAnswer.equals("")) {

        JOptionPane.showMessageDialog(
                frame,
                "Please select an answer first."
        );

        return;
    }

    Question q = quiz.getQuestions().get(currentQuestion);

    if (selectedAnswer.equals(q.getCorrectAnswer())) {

        quiz.increaseScore();
    }

    // Stop the timer for the current question
    timerManager.stopTimer();

    // Move to the next question
    currentQuestion++;

    if (currentQuestion < quiz.getQuestions().size()) {

        showQuestion();

        startTimer(frame);

    } else {

        showResult(frame);
    }
}
    
// Timer for each question
public static void startTimer(JFrame frame) {

    timeLeft = 15;

    int questionNumber = currentQuestion;

    timerManager.startTimer(() -> {

        SwingUtilities.invokeLater(() -> {

            if (currentQuestion != questionNumber) {
                return;
            }

            JOptionPane.showMessageDialog(
                    frame,
                    "Time is up for this question!",
                    "Time Up",
                    JOptionPane.INFORMATION_MESSAGE
            );

            currentQuestion++;

            if (currentQuestion < quiz.getQuestions().size()) {
                showQuestion();
                startTimer(frame);
            } else {
                showResult(frame);
            }
        });
    });

    timerThread = new Thread(() -> {

        while (currentQuestion == questionNumber) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }

            SwingUtilities.invokeLater(() -> {

                if (currentQuestion == questionNumber) {
                    timeLeft = timerManager.getTimeLeft();

                    timerLabel.setText(
                            "Time left: " + timeLeft + " seconds"
                    );
                }
            });
        }
    });

    timerThread.start();
}
// Showing the final result
public static void showResult(JFrame oldFrame) {

    oldFrame.dispose();
    result = new Result(
        playerName,
        quiz.getScore(),
        quiz.getQuestions().size()
);
    scoreManager.saveResult(result);

    JFrame resultFrame = new JFrame("Quiz Result");

    resultFrame.setSize(500, 400);
    resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    resultFrame.setLocationRelativeTo(null);

    JPanel panel = new JPanel();
panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
panel.setBackground(new Color(245, 247, 250));

    panel.add(Box.createVerticalStrut(40));

    JLabel title = new JLabel("QUIZ COMPLETED!");
   title.setFont(new Font("Arial", Font.BOLD, 28));
title.setForeground(new Color(45, 45, 45));
    title.setAlignmentX(Component.CENTER_ALIGNMENT);

    panel.add(title);

    panel.add(Box.createVerticalStrut(30));

    JLabel nameLabel = new JLabel("Player: " + playerName);
    nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
    nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

    panel.add(nameLabel);

    panel.add(Box.createVerticalStrut(15));

    JLabel scoreLabel = new JLabel(
            "Score: " + quiz.getScore()
            + " / " + quiz.getQuestions().size()
    );

    scoreLabel.setFont(new Font("Arial", Font.BOLD, 24));
scoreLabel.setForeground(new Color(45, 45, 45));
    scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

    panel.add(scoreLabel);

    panel.add(Box.createVerticalStrut(15));

    int percentage = (quiz.getScore() * 100)
            / quiz.getQuestions().size();

    JLabel percentageLabel = new JLabel(
            "Percentage: " + percentage + "%"
    );

   percentageLabel.setFont(new Font("Arial", Font.BOLD, 20));
percentageLabel.setForeground(new Color(70, 70, 70));
    percentageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

    panel.add(percentageLabel);

    panel.add(Box.createVerticalStrut(30));

   JButton restartButton = new JButton("RESTART QUIZ");
restartButton.setAlignmentX(Component.CENTER_ALIGNMENT);
restartButton.setFont(new Font("Arial", Font.BOLD, 14));
restartButton.setFocusPainted(false);

panel.add(restartButton);

panel.add(Box.createVerticalStrut(10));

JButton historyButton = new JButton("VIEW SCORE HISTORY");
historyButton.setAlignmentX(Component.CENTER_ALIGNMENT);
historyButton.setFont(new Font("Arial", Font.BOLD, 14));
historyButton.setFocusPainted(false);

panel.add(historyButton);

panel.add(Box.createVerticalStrut(10));

JButton exitButton = new JButton("EXIT");
exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
exitButton.setFont(new Font("Arial", Font.BOLD, 14));
exitButton.setFocusPainted(false);

panel.add(exitButton);
restartButton.setAlignmentX(Component.CENTER_ALIGNMENT);



panel.add(Box.createVerticalStrut(10));





restartButton.addActionListener(e -> {

    timerManager.stopTimer();

    currentQuestion = 0;
    quiz = new Quiz();

    QuestionManager questionManager = new QuestionManager();

    for (Question question : questionManager.getQuestions()) {
        quiz.addQuestion(question);
    }

    quizManager = new QuizManager(player, quiz);

    resultFrame.dispose();

    createQuizWindow();
});
historyButton.addActionListener(e -> {
    showScoreHistory();
});


exitButton.addActionListener(e -> {
    System.exit(0);
});

    resultFrame.add(panel);

    resultFrame.setVisible(true);
}


// Showing previous quiz results
public static void showScoreHistory() {

    String history = scoreManager.getHistory();

    JTextArea textArea = new JTextArea(history);

    textArea.setEditable(false);
    textArea.setFont(new Font("Arial", Font.PLAIN, 16));

    JScrollPane scrollPane = new JScrollPane(textArea);

    scrollPane.setPreferredSize(
            new Dimension(400, 250)
    );

    JOptionPane.showMessageDialog(
            null,
            scrollPane,
            "Score History",
            JOptionPane.INFORMATION_MESSAGE
    );
}
}