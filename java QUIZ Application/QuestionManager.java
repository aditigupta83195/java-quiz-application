import java.util.ArrayList;

public class QuestionManager {

    private ArrayList<Question> questions;

    public QuestionManager() {
        questions = new ArrayList<>();
        addQuestions();
    }

    private void addQuestions() {

        questions.add(new Question(
                "Which keyword is used to inherit a class in Java?",
                "implements", "extends", "inherits", "super", "B"
        ));

        questions.add(new Question(
                "Which method is the starting point of a Java program?",
                "start()", "run()", "main()", "begin()", "C"
        ));

        questions.add(new Question(
                "Which of the following is not a primitive data type?",
                "int", "double", "String", "char", "C"
        ));

        questions.add(new Question(
                "Which keyword is used to create an object?",
                "new", "create", "object", "make", "A"
        ));

        questions.add(new Question(
                "Which collection can store elements dynamically?",
                "Array", "ArrayList", "String", "Scanner", "B"
        ));

        questions.add(new Question(
                "Which keyword is used to define a class?",
                "object", "class", "define", "new", "B"
        ));

        questions.add(new Question(
                "Which keyword prevents a variable from being changed?",
                "static", "constant", "final", "fixed", "C"
        ));

        questions.add(new Question(
                "Which OOP concept allows the same method to have different forms?",
                "Inheritance", "Polymorphism", "Encapsulation", "Abstraction", "B"
        ));

        questions.add(new Question(
                "Which block is commonly used to handle exceptions?",
                "if", "switch", "try", "loop", "C"
        ));

        questions.add(new Question(
                "Which class is commonly used to take input from the keyboard?",
                "Input", "Scanner", "Reader", "Keyboard", "B"
        ));
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }
}
