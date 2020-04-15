/**
 * A record of a player's name and all the prizes he has won, the total worth of the prizes, 
 * and how much money he has spent.
 * @author  Mirek
 * @version 5 Sempt. 2017
 */
public class Player
{
    // instance variables
    private String name;
    private String prizes;
    private int totalCost;
    private int totalWorth;

    /**
     * Create a new player with empty name, prizes, total cost and total worth.
     */
    public Player()
    {
        // initialise instance variables
        name = "";
        prizes = "";
        totalCost = 0;
        totalWorth = 0;
    }

    /**
     * @Return the cost of a player.
     */
    public int getCost()
    {
        return totalCost;
    }

    /**
     * @Return the name of a player.
     */
    public String getName()
    {
        return name;
    }

    /**
     * @Return the prizes of a player.
     */
    public String getPrizes()
    {
        return prizes;
    }

    /**
     * @Return the prizes' worth of a player.
     */
    public int getWorth()
    {
        return totalWorth;
    }

    /**
     * Add the cost of a player.
     */
    public void setCost(int cost)
    {
        totalCost += cost;
    }

    /**
     * Set a player's name.
     */
    public void setName(String playerName)
    {
        name = playerName;
    }

    /**
     * Add the prizes of a player.
     */
    public void setPrizes(int guess)
    {
        String prize = "";
        switch (guess)
        {
            case 1:
            prize = "Pen, ";
            break;
            case 2:
            prize = "Book, ";
            break;
            case 3:
            prize = "DVD, ";
            break;
            case 4:
            prize = "Mouse, ";
            break;
            case 5:
            prize = "Keyboard, ";
            break;
        }
        prizes += prize;
    }

    /**
     * Add the prizes' worth of a player.
     */
    public void setWorth(int guess)
    {
        int worth = 0;
        switch (guess)
        {
            case 1:
            worth = 10;
            break;
            case 2:
            worth = 20;
            break;
            case 3:
            worth = 30;
            break;
            case 4:
            worth = 40;
            break;
            case 5:
            worth = 50;
            break;
        }
        totalWorth += worth;
    }

}
