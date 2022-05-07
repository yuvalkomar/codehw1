public class GameBoard {
    private final int BOARD_SIZE = 100;

    private Square[] Board;

    public GameBoard() {
        Board = new Square[BOARD_SIZE];
        for(int i=0;i<99;i++)
            Board[i] = new Square(i+1);
    }

    public Square getSquare(int squareNumber){
        return this.Board[squareNumber-1];
    }
}
