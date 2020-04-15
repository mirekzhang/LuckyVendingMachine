/**
 * This is a random number generator that generates an integer between 1-5.
 *
 * @author  Mirek
 * @version 14 Sempt. 2017
 */
public class LuckyGuessGenerator
{
    // instance variables
    private int randomNumber;
    
    /**
     * Create a new, empty lucky guess generator.
     */
    public LuckyGuessGenerator()
    {
        // initialise instance variables
        randomNumber = 0;
    }

    /**
     * Generate an integer between 1-5.
     * @Return the integer.
     */
    public int randomNumber()
    {
        randomNumber = (int)(Math.random() * 5 + 1);
        return randomNumber;
    }
}
