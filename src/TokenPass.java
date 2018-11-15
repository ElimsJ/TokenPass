public class TokenPass
{
    private int[] board;
    private int currentPlayer;


    public TokenPass(int playerCount)
    {
        board = new int[playerCount];
        for ( int i = 0; i < playerCount;i++)
        {
            board[i] =  1 + (int) Math.random()*10;
        }
    }


    public void distributeCurrentPlayerToken()
    {
        int nextPlayer = currentPlayer;
        int numToDistribute = board[currentPlayer];
        board[currentPlayer] = 0;

        while(numToDistribute > 0)
        {
            nextPlayer = (nextPlayer +1 % board.length);
            board[nextPlayer]++;
            numToDistribute--;
        }
    }

    public void printBoard()
    {
        for (int i = 0; i < board.length; i++)
        {
            System.out.print("Player " + i + ": " + board[i] + " | ");
        }
        System.out.print("\n");
    }
    public void nextPlayer()
    {
        currentPlayer++;
    }

    public int gameOver()
    {
        int winnerIdx = -1;
        boolean gameOver = false;

        if (!gameOver)
        {
            for (int i: board)
            {
                if (i == 0)
                    gameOver = true;
            }
        }

        if(gameOver)
        {
            int winnerVal = -1;
            for (int i = 0; i < board.length; i++)
            {
                if (board[i] > winnerVal)
                    winnerIdx = i;
            }
        }

        return winnerIdx;
    }
}

