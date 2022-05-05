public class Square {
    private int squareNum;
    private Snake snakeHead;
    private Ladder ladderStart;
    public Square(int squareNumber)
    {
        this.squareNum = squareNumber;
        this.snakeHead = null;
        this.ladderStart = null;
    }
    public Square(int squareNumber,Snake snake,Ladder ladder)
    {
        this.squareNum = squareNumber;
        this.snakeHead = snake;
        this.ladderStart = ladder;
    }

    public void setSnakeHead(Snake snake){
        this.snakeHead = snake;
    }

    public void setLadderStart(Ladder ladder){
        this.ladderStart = ladder;
    }
}
