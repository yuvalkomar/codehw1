public class Player {
    private String name;
    private GamePiece piece;


    public Player(String PlayerName, String PlayerPiece){
        this.name = PlayerName;
        this.piece = new GamePiece(PlayerPiece);
    }
}
