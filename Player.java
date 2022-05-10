public class Player {
    private String name;
    private GamePiece piece;
    private int squareNum;

    public Player(String PlayerName, String PlayerPiece){
        this.name = PlayerName;
        this.piece = new GamePiece(PlayerPiece);
        this.squareNum = 1;
    }

    public String getName()
    {
        return name;
    }

    public String getGamePieceColor()
    {
       return this.piece.getPieceColor();
    }

    public int getSquareNum(){
        return this.squareNum;
    }

    public void moveSquareNum(int rolledNumber){
        if(squareNum + rolledNumber >= 1 && squareNum + rolledNumber <= 100)
            this.squareNum = squareNum + rolledNumber;
        if(squareNum + rolledNumber < 1)
            this.squareNum = 1;
        if(squareNum + rolledNumber > 100) {
            int moveBack = this.squareNum + rolledNumber - 100;
            this.squareNum = 100 - moveBack;
        }
    }

}
