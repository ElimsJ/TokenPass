
public class TokenPass {
    private int[] board;
    private int currentPlayer;
    private int nextPlayer;
    int gameOver = -1;
    public TokenPass(int playerCount)
    {
        board = new int[playerCount];
        for ( int i = 0; i < playerCount;i++)
        {
            board[i] =  1 + (int) Math.random()*10;
        }
    }
    public void nextPlayer()
    {
        nextPlayer = currentPlayer;
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
    public int gameOver()
    {
        gameOver = currentPlayer;
        return gameOver;
    }
    public void printBoard()
    {
        for(int i = 0; i<board.length; i ++)
        {
            System.out.println("Player "+ board[i] + ":");
        }
    }

}
