import java.util.Scanner;
/**
 * The main program of Lucky Vending Machine.
 *
 * @author  Mirek
 * @version 14 Sempt. 2017
 */
public class Game
{
    // instance variables
    private LuckyGuessGenerator number;
    private Player player;

    /**
     * Create a new game with empty player data.
     */
    public Game()
    {
        // initialise instance variables
        number = new LuckyGuessGenerator();
        player = new Player();
    }

    /**
     * Display the main menu.
     */
    public void displayMenu()
    {
        System.out.println("\nWelcome to the Lucky Vending Machine");
        System.out.println("==============================");
        System.out.println("(1) Set Up New Player");
        System.out.println("(2) Guess A Prize");
        System.out.println("(3) What Have I Won So Far?");
        System.out.println("(4) Display Game Help");
        System.out.println("(5) Exit Game");
        System.out.println("Choose an option :");
    }

    /**
     * Display the record of a player's name and all the prizes he has won, the total worth of  
     * the prizes, and how much money he has spent.
     */
    public void displayPrizes()
    {
        if (player.getPrizes().equals(""))
        {
            System.out.println("\nPlayer " + player.getName() + " has won nothing.");
            System.out.println("Total cost is: $" + player.getCost() + ". Don't give up!");
        }
        else
        {
            System.out.println("\nPlayer " + player.getName() + " has won:");
            System.out.println("    " + player.getPrizes());
            System.out.println("Total worth is: $" + player.getWorth());
            System.out.println("Total cost is: $" + player.getCost());
        }
    }

    /**
     * Display the game help.
     */
    public void gameHelp()
    {
        System.out.println("\nWelcome to the Lucky Vending Machine.");
        System.out.println("This is an interesting game that you may win a lot of prizes.");
        System.out.println("Please read the rules as follow, which will help you.");
        System.out.println("1.You need to set a player by choosing (1) before you play this");
        System.out.println("  game. Otherwise, you cannot guess a prize nor see the record.");
        System.out.println("  If you choose (1) again, a new player will be created, and");
        System.out.println("  the current player will be deleted.");
        System.out.println("2.OK, let's start the game by choosing (2).");
        System.out.println("  The prizes are decided by the vending machine generating a");
        System.out.println("  random number between 1-5. To win a prize, you will need to");
        System.out.println("  guess correctly the number generated by the machine. Each");
        System.out.println("  number represents a particular prize, which is worth between");
        System.out.println("  $10-50, and each guess will cost you between $1-5.");
        System.out.println("3.The rules of prizes are :");
        System.out.println("  Number   Prize     Worth   Cost");
        System.out.println("    1      Pen        $10     $1");
        System.out.println("    2      Book       $20     $2");
        System.out.println("    3      DVD        $30     $3");
        System.out.println("    4      Mouse      $40     $4");
        System.out.println("    5      Keyboard   $50     $5");
        System.out.println("4.If you enter a number which is less than 1, or more than 5,");
        System.out.println("  it will be rejected, and you do not lose any money.");
        System.out.println("5.Choosing (3), you can check the record of all the prizes you");
        System.out.println("  have won, the total worth of the prizes, and how much money");
        System.out.println("  you have spent.");
        System.out.println("6.Choosing (5), you will exit the game, and all statistics will");
        System.out.println("  be cleared.");
    }

    /**
     * Guess a number.
     */
    public void guessNumber()
    {
        System.out.println("Guess a number between 1-5:");
        Scanner getGuess = new Scanner(System.in);
        int guess = getGuess.nextInt();
        if (guess < 1 || guess > 5)
            System.out.println("Error: only guess a number between 1-5.");
        else
        {
            int result = number.randomNumber();
            boolean compareResult;
            compareResult = (result == guess);
            System.out.println("Your guess: " + guess + "\nMy guess  : " + result);
            player.setCost(guess);
            if (compareResult)
            {
                player.setPrizes(guess);
                player.setWorth(guess);
                switch (guess)
                {
                    case 1:
                    System.out.println("Congratulations, you have won a PEN, worth $10!");
                    break;
                    case 2:
                    System.out.println("Congratulations, you have won a BOOK, worth $20!");
                    break;
                    case 3:
                    System.out.println("Congratulations, you have won a DVD, worth $30!");
                    break;
                    case 4:
                    System.out.println("Congratulations, you have won a MOUSE, worth $40!");
                    break;
                    case 5:
                    System.out.println("Congratulations, you have won a KEYBOARD, worth $50!");
                    break;
                }
            }
            else
            {
                System.out.println("What a pity! You have won NOTHING!");
                System.out.println("Please try again.");
            }
        }
    }

    /**
     * Set a new player.
     */
    public void setPlayer()
    {
        player = new Player();
        System.out.println("Please enter your name: ");
        Scanner getName = new Scanner(System.in);
        String name = getName.nextLine();
        player.setName(name);
        if (name.trim().isEmpty())
            System.out.println("Sorry, player name cannot be blank!");
        else
        {
            System.out.println("Player has been created. " + name + ", enjoy your game!");
        }
    }

    /**
     * Start the game.
     */
    public void startGame()
    {
        for (int i = 0; i < 1;)
        {
            displayMenu();
            Scanner getChoice = new Scanner(System.in);
            int choice = getChoice.nextInt();
            String name = "";
            name = player.getName();
            if (name.trim().isEmpty() && (choice == 2 || choice == 3)) 
                System.out.println("Error : Player has not been set up!");

            else
            {
                switch (choice)
                {
                    case 1:
                    setPlayer();
                    break;
                    case 2:
                    guessNumber();
                    break;
                    case 3:
                    displayPrizes();
                    break;
                    case 4:
                    gameHelp();
                    break;
                    case 5:
                    System.out.println("Goodbye. Thank you for playing.");
                    System.exit(0);
                    i = 1;
                    break;
                    default:
                    System.out.println("Error: Please only choose 1-5.");
                    break;
                }
            }
        }
    }
}
