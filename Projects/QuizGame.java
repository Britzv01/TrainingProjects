import java.util.Random;
import java.util.Scanner;

public class QuizGame {
    Scanner scan = new Scanner(System.in);
    Random random = new Random();
    String [] quizQuestions = { "What is the capital city of Australia?",
                                "Which planet in our solar system is known as the \"Red Planet\"?",
                                "In computer science, what does \"HTTP\" stand for?",
                                "In what year did the Titanic sink in the Atlantic Ocean?",
                                "Who wrote the classic novel \"1984\"?" };

    String [][] quizChoices = { {"A) Sydney", "B) Melbourne", "C) Canberra", "D) Perth"},
                                {"A) Venus", "B) Mars", "C) Jupiter", "D) Saturn"},
                                {"A) HyperText Transfer Protocol", "B) Hyperlink Transfer Technology", "C) HyperText Transmission Process", "D) HyperText Transport Protocol"},
                                {"A) 1905", "B) 1912", "C) 1918", "D) 1923"},
                                {"A) Aldous Huxley", "B) George Orwell", "C) Ray Bradbury", "D) J.R.R. Tolkien" }};

    int [] finishedQuestions = new int[quizQuestions.length];

    char [] quizAnswers = {'C', 'B', 'A', 'B', 'B'};

    void startGame() throws InterruptedException {
        int correctAnswerCounter = 0;
        int currentQuestion;

        for (int i = 0; i < quizQuestions.length; i++) {
            //Handles the Randomizer
            boolean questionFinished = false;

            while(true) {
                currentQuestion = random.nextInt(0, quizQuestions.length);

                for (int k = 0; k < quizQuestions.length; k++) {
                    if (currentQuestion == finishedQuestions[k]) {
                        questionFinished = true;
                    }
                }

                if (questionFinished == false){
                    break;
                }
            }

            //Outputs the Question
            Thread.sleep(1000);
            System.out.println("---------------------------");
            System.out.printf("%d. %s%n", (i + 1), quizQuestions[currentQuestion]);
            finishedQuestions[i] = currentQuestion;

            //Outputs the Choices
            for (int j = 0; j < quizChoices[i].length; j++) {
                System.out.println(quizChoices[currentQuestion][j]);
            }

            System.out.println("---------------------------");
            System.out.print("Guess: ");
            char guess = Character.toUpperCase(scan.next().charAt(0));
            System.out.println("---------------------------");

            if (guess != quizAnswers[currentQuestion]){
                System.out.println("Wrong Answer!");
                continue;
            }

            System.out.println("Correct Answer!");
            correctAnswerCounter++;
        }

        System.out.println("---------------------------");
        System.out.printf("Final Score: %d / %d", correctAnswerCounter, quizQuestions.length);
    }

    public static void main (String [] args) throws InterruptedException {
        QuizGame app = new QuizGame();

        System.out.println("Welcome to Java Quiz Game!");

        app.startGame();
    }
}
