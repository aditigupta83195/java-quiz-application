# Java Quiz Application

## 1. Project Overview

The Java Quiz Application is a simple desktop-based quiz application developed using Java.

The application allows a user to enter their name and attempt a set of multiple-choice questions. Each question has four options and a time limit of 15 seconds. The selected answer is checked automatically and the score is updated.

After completing the quiz, the application displays the player's score and percentage. The quiz result can also be saved and viewed later using the score history option.

The project was developed to understand and apply different Java concepts in a practical application.

---

## 2. Objectives

The main objectives of this project are:

- To develop a simple quiz application using Java.
- To create a graphical user interface using Java Swing.
- To use Object-Oriented Programming concepts.
- To implement multiple-choice questions.
- To add a timer for each question.
- To calculate the score automatically.
- To save and display quiz results.
- To practice file handling and exception handling.
- To understand the use of multithreading in Java.
- To organize a Java project into different classes.

---

## 3. Main Features

The application provides the following features:

- Player name input
- Multiple-choice quiz
- Four options for each question
- 15-second timer for every question
- Automatic movement to the next question when time runs out
- Automatic answer checking
- Score calculation
- Percentage calculation
- Final result screen
- Score history
- Restart quiz option
- Exit option
- Basic input validation
- File handling for storing quiz results
- Error handling for file operations

---

## 4. Technologies Used

| Technology | Purpose |
|---|---|
| Java | Main programming language |
| Java Swing | Graphical user interface |
| ArrayList | Storing quiz questions |
| File Handling | Saving and reading quiz results |
| Exception Handling | Handling file-related errors |
| Multithreading | Implementing the question timer |
| Visual Studio Code | Development environment |
| Git | Version control |
| GitHub | Source code repository |

---

## 5. System Requirements

The project is a Java desktop application and does not require an internet connection after the project has been downloaded.

### Minimum Requirements

- Java Development Kit (JDK)
- Visual Studio Code or any Java-supported IDE
- Git (only required if the project is cloned from GitHub)
- A computer capable of running Java Swing applications

No external database or third-party Java library is required.

---

## 6. Environment Setup

### Step 1: Install Java

The project requires the Java Development Kit (JDK).

After installing Java, open Terminal or Command Prompt and run:

```bash
java -version
```

If Java is installed correctly, the terminal will display the installed Java version.

### Step 2: Install Visual Studio Code

Install Visual Studio Code on your computer.

For Java development, install the required Java extensions if they are not already installed.

The project can also be opened using another Java-supported IDE.

### Step 3: Install Git

Git is required if the project is downloaded by cloning the GitHub repository.

Check whether Git is installed by running:

```bash
git --version
```

---

## 7. Download or Clone the Project

The project can be downloaded from GitHub.

Clone the repository using:

```bash
git clone YOUR_GITHUB_REPOSITORY_URL
```

Move into the project directory:

```bash
cd JavaQuizApplication
```

The project can then be opened in Visual Studio Code.

---

## 8. Project Structure

The project is organized into multiple Java classes.

```text
JavaQuizApplication/
│
├── Main.java
├── Question.java
├── QuestionManager.java
├── Quiz.java
├── QuizManager.java
├── Player.java
├── Result.java
├── ScoreManager.java
├── TimerManager.java
├── .gitignore
├── README.md
└── statement.md
```

### Description of Main Files

| File | Purpose |
|---|---|
| Main.java | Controls the graphical interface and quiz flow |
| Question.java | Represents an individual quiz question |
| QuestionManager.java | Stores and manages quiz questions |
| Quiz.java | Maintains questions and score |
| QuizManager.java | Manages the player and quiz |
| Player.java | Stores player information |
| Result.java | Stores quiz result information |
| ScoreManager.java | Saves and reads score history |
| TimerManager.java | Handles the timer for each question |
| quiz_results.txt | Stores quiz results locally |

The `quiz_results.txt` file is ignored by Git using `.gitignore`.

---

## 9. Dependencies

The project does not require any external Java libraries.

It uses standard Java libraries such as:

- `javax.swing`
- `java.awt`
- `java.util`
- `java.io`

These libraries are available as part of the Java Development Kit.

---

## 10. Configuration

No special configuration is required to run the application.

The quiz questions are stored directly inside `QuestionManager.java`.

The score history is stored locally in:

```text
quiz_results.txt
```

The application automatically creates or updates the file when quiz results are saved.

---

## 11. Compile the Project

Open the project folder in Terminal.

Compile all Java files using:

```bash
javac *.java
```

If there are no compilation errors, Java `.class` files will be generated.

---

## 12. Run the Project

After compiling the project, run the application using:

```bash
java Main
```

The Java Quiz Application window will open.

---

## 13. How to Use the Application

### Step 1: Enter Player Name

Enter your name in the name field.

Click the **Start Quiz** button.

### Step 2: Answer Questions

A question with four options will be displayed.

Select one option.

Click the **Next** button to submit the answer.

### Step 3: Timer

Each question has a time limit of 15 seconds.

If the time reaches zero, the application automatically moves to the next question.

### Step 4: View Result

After all questions are completed, the result screen displays:

- Player name
- Score
- Total questions
- Percentage

### Step 5: Score History

The **View Score History** option displays previously saved quiz results.

### Step 6: Restart or Exit

The user can either:

- Restart the quiz
- Exit the application

---

## 14. Application Workflow

The basic workflow of the application is:

```text
Start Application
       ↓
Enter Player Name
       ↓
Validate Name
       ↓
Start Quiz
       ↓
Display Question
       ↓
Start 15-Second Timer
       ↓
Select Answer
       ↓
Check Answer
       ↓
Update Score
       ↓
More Questions?
     /       \
   Yes        No
    ↓          ↓
Next Question  Display Result
    ↓          ↓
 Start Timer   Save Result
                 ↓
            Score History
                 ↓
              Exit/Restart
```

If the timer reaches zero, the application automatically moves to the next question.

---

## 15. Input and Output

### Input

The application accepts:

- Player name
- Multiple-choice answer selected by the player

### Output

The application provides:

- Quiz questions
- Four answer options
- Timer
- Current question progress
- Final score
- Percentage
- Score history
- Error and validation messages

---

## 16. Object-Oriented Programming Concepts Used

The project applies several Object-Oriented Programming concepts.

### Classes and Objects

Different classes are created for different responsibilities.

Examples:

- `Question`
- `Player`
- `Quiz`
- `Result`
- `QuizManager`

Objects are created from these classes during program execution.

### Encapsulation

Class variables are declared as private and accessed through methods.

Example:

```java
private String name;

public String getName() {
    return name;
}
```

### Constructors

Constructors are used to initialize objects.

Example:

```java
public Player(String name) {
    this.name = name;
}
```

### Abstraction

Different classes handle specific responsibilities so that the main program does not need to manage every detail directly.

### Modularity

The application is divided into multiple classes instead of keeping the entire program in one class.

---

## 17. ArrayList Implementation

The application uses `ArrayList` to store quiz questions.

Example:

```java
private ArrayList<Question> questions;
```

The questions are added using:

```java
questions.add(new Question(...));
```

`ArrayList` allows the application to store and manage multiple question objects dynamically.

---

## 18. File Handling

The application uses file handling to store quiz results.

The `ScoreManager` class writes the result into:

```text
quiz_results.txt
```

The application uses:

```java
FileWriter
```

to save results.

The saved information includes:

- Player name
- Score
- Total questions
- Percentage

The application can also read the stored results and display them using the **Score History** option.

---

## 19. Exception Handling

Exception handling is used mainly during file operations.

Example:

```java
try {
    FileWriter writer = new FileWriter(fileName, true);

    // Save result

    writer.close();

} catch (IOException e) {
    System.out.println("Could not save the result.");
}
```

This prevents the application from stopping unexpectedly if a file-related error occurs.

---

## 20. Multithreading and Timer

The application uses a separate thread to implement the question timer.

A timer thread runs in the background while the user answers a question.

The timer:

- Starts at 15 seconds.
- Decreases every second.
- Stops when the question is answered.
- Automatically moves to the next question when the time reaches zero.

The `TimerManager` class is responsible for managing the timer.

This demonstrates the use of **multithreading in Java**.

---

## 21. Input Validation and Error Handling

The application performs basic validation before accepting user actions.

### Name Validation

The user cannot start the quiz without entering a name.

If the name field is empty, the application displays:

```text
Please enter your name.
```

### Answer Validation

The user must select an option before clicking the Next button.

If no option is selected, the application displays:

```text
Please select an answer first.
```

### File Error Handling

If the application cannot save or read the score history, an appropriate message is displayed.

---

## 22. Testing

The application was tested using different test cases.

| Test Case | Expected Result |
|---|---|
| Start without entering name | Display validation message |
| Enter valid name | Quiz starts |
| Select correct answer | Score increases |
| Select incorrect answer | Score remains unchanged |
| Click Next without selecting answer | Display validation message |
| Timer reaches zero | Move to next question |
| Complete all questions | Display result |
| Click Score History | Display saved results |
| Click Restart Quiz | Start a new quiz |
| Click Exit | Close application |

The application was also compiled and executed to verify that the main features work correctly.

---

## 23. Non-Functional Requirements

The application considers the following non-functional requirements:

### 1. Usability

The graphical interface is simple and easy to understand.

### 2. Reliability

The application validates important user inputs and handles file-related errors.

### 3. Performance

The application is lightweight and uses only standard Java libraries.

### 4. Maintainability

The application is divided into different classes, making the code easier to understand and modify.

### 5. Error Handling

The application handles invalid input and file-related exceptions.

### 6. Resource Efficiency

The application does not require a database or external services and uses limited system resources.

---

## 24. Challenges Faced

During development, several challenges were encountered.

### Timer Implementation

Implementing a timer that works correctly with the graphical interface required the use of multithreading.

### GUI Management

Creating and updating multiple Swing components required careful handling of buttons, labels and radio buttons.

### Score Management

The application needed to maintain the score while moving between questions and display the correct final result.

### File Handling

Saving and reading previous quiz results required file handling and exception handling.

### Class Organization

The application was divided into different classes so that each class had a specific responsibility.

---

## 25. Future Enhancements

The application can be improved in the future by adding:

- Randomized questions
- Multiple quiz categories
- Different difficulty levels
- Larger question database
- User login and registration
- Database integration
- Leaderboard
- Admin panel for adding and removing questions
- Detailed performance reports
- Sound effects
- Improved graphical interface
- Online quiz functionality
- Multiple-player support

---

## 26. Learning Outcomes

Through this project, the following concepts were practiced:

- Java programming
- Object-Oriented Programming
- Classes and objects
- Constructors
- Encapsulation
- ArrayList
- Java Swing
- Event handling
- File handling
- Exception handling
- Multithreading
- GUI development
- Basic software project organization
- Git and GitHub
- Testing and debugging

The project helped in understanding how individual Java concepts can be combined to develop a complete application.

---

## 27. Author

**[ADITI GUPTA]**

B.Tech - Computer Science and Engineering (AIML)  
VIT Bhopal University
