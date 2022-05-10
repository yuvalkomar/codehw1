public class Snake  {
    private int squareNumber;
    private int snakeLength;

    public Snake(int snakePosition, int length){
        this.squareNumber = snakePosition;
        this.snakeLength = length;
    }

    public int getSnakeLength(){
        return -1 * this.snakeLength;
    }

}
