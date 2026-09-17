import java.util.Random;
import java.util.Scanner;

public class QuizGame {
    Scanner scan = new Scanner(System.in);
    Random random = new Random();

    public QuizGame(){
        for (int m = 0; m < quizQuestions.length; m++){
            finishedQuestions[m] = -1;
        }
    }
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

    public void startGame() throws InterruptedException {
        int correctAnswerCounter = 0;
        int currentQuestion;
        Thread.sleep(1000);

        for (int i = 0; i < quizQuestions.length; i++) {
            //Handles the Randomizer
            while(true) {
                boolean questionFinished = false;

                currentQuestion = random.nextInt(0, quizQuestions.length);

                for (int k = 0; k < quizQuestions.length; k++) {
                    if (currentQuestion == finishedQuestions[k]) {
                        questionFinished = true;
                        break;
                    }
                }

                if (questionFinished){
                    continue;
                }

                break;
            }

            //Outputs the Question
            System.out.println("---------------------------");
            System.out.printf("%d. %s%n", (i + 1), quizQuestions[currentQuestion]);
            finishedQuestions[i] = currentQuestion;

            //Outputs the Choices
            for (int j = 0; j < quizChoices[currentQuestion].length; j++) {
                System.out.println(quizChoices[currentQuestion][j]);
            }

            //Scans the Answer
            System.out.println("---------------------------");
            System.out.print("Guess: ");
            char guess = Character.toUpperCase(scan.next().charAt(0));
            System.out.println("---------------------------");

            //Checks the Answer
            if (guess != quizAnswers[currentQuestion]){
                System.out.println("Wrong Answer!");
                continue;
            }

            System.out.println("Correct Answer!");
            correctAnswerCounter++;
        }
        //Displays the Final Score
        System.out.println("---------------------------");
        System.out.printf("Final Score: %d / %d%n", correctAnswerCounter, quizQuestions.length);
    }

     static void main (String [] args) throws InterruptedException {
        QuizGame app = new QuizGame();

        System.out.println("Welcome to Java Quiz Game!");

        app.startGame();

        app.scan.close();
    }
}
