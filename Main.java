import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String choice1;
        String choice2;
        String result;
        String play;
        Scanner scan = new Scanner(System.in);
        boolean playAgain = true;
        while (playAgain){

            System.out.println("Player One choice(R for Rock, P for Paper,S for Scissors): ");
            choice1 = scan.nextLine();
            System.out.println("Player two choice(Rock, Paper, Scissors): ");
            choice2 = scan.nextLine();

            result = rps(choice1, choice2);
            System.out.println(result);
            System.out.println("*************************************************");
            System.out.println("would you like to play again? (Y or N)");
            play = scan.nextLine();
            playAgain = (play.equalsIgnoreCase("y")? playAgain = true : false);
        }
    }

    public static String rps(String choice1, String choice2){
        String result;

        if(choice1.equalsIgnoreCase(choice2)){
            return "Tie";
        }
        else if(choice2.equalsIgnoreCase("r") && choice1.equalsIgnoreCase("p")){
            return "Player One Won";
        }
        else if(choice2.equalsIgnoreCase("p") && choice1.equalsIgnoreCase("s")){
            return "Player One Won";
        }
        else if(choice2.equalsIgnoreCase("s") && choice1.equalsIgnoreCase("r")){
            return "Player One Won";
        }
        else if(choice1.equalsIgnoreCase("r") && choice2.equalsIgnoreCase("p")){
            return "Player Two Won";
        }
        else if(choice1.equalsIgnoreCase("p") && choice2.equalsIgnoreCase("s")){
            return "Player Two Won";
        }
        else if(choice1.equalsIgnoreCase("s") && choice2.equalsIgnoreCase("r")){
            return "Player Two Won";
        }
        else
            return  "Invalid input";
    }

}
