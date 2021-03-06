import java.util.Random;
public class Concentration extends Board
{
    // create the game board
    private Tile[][] gameboard = makeBoard();

    public static final int CONCENTRATION = 100;
    public static final int SEVENS = 200;
    private int gameRules;

    public Concentration() {
        String[] cards = getCards();
        int numCards = cards.length - 1;

        for (int i = 0; i < gameboard.length; i++)
        {
            for (int j = 0; j <gameboard[0].length; j++)
            {
                Random rand = new Random();
                int r = rand.nextInt(numCards);
                gameboard[i][j] = new Tile(cards[r]);
                cards[r] = cards[numCards];
                numCards = numCards -1;
            }
        }


    }
    public boolean allTilesMatch()
    {
        for (int i = 0; i < gameboard.length; i++)
        {
            for (int j = 0; j <gameboard[0].length; j++)
            {
                if (!gameboard[i][j].matched())
                {
                    return false;
                }
            }
        }
        return true;
    }

    public String checkForMatch(int row1, int column1, int row2, int column2) {

        boolean tilesMatch = false;
        String msg = "";

        Tile tile1 = gameboard[row1][column1];
        Tile tile2 = gameboard[row2][column2];

        if (gameRules == CONCENTRATION)
        {
            tilesMatch = tile1.equals(tile2);

        }
        if (gameRules == SEVENS)
        {
            tilesMatch = tile1.addsTo7(tile2);

        }
        if (tilesMatch == true)
        {
            tile1.foundMatch();
            tile2.foundMatch();
            System.out.println("There is a match ");
        }
        else
            {
                tile1.faceUp(true);
                tile2.faceUp(true);
            }
        return msg;
    }

    public void showFaceUp (int row, int column)
    {
        Tile tile = gameboard[row][column];
        tile.faceUp(true);
        tile.faceUp(true);
    }

    public String toString() {
        String boardValues = "";

        for (int i = 0; i < gameboard.length; i++)
        {
            for (int j = 0; j <gameboard[0].length; j++)
            {
                Tile t = gameboard[i][j];

                if (t.isFaceUp())
                {
                    boardValues +=t.getFace();
                }
                else
                    {
                        boardValues += t.getBack();
                    }
                    boardValues += "\t";
            }
            boardValues += "\n";
        }

        return boardValues;
    }

    public boolean validSelection(int i, int j)
    {
        if (i < gameboard.length)
        {
            if (j < gameboard.length)
            {
                if (!gameboard[i][j].matched())
                {
                     return true;
                }
            }

        }
        return false;
    }

}

