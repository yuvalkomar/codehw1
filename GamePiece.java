public class GamePiece {
    private Color piece_Color;

    /**
     * Construct a piece
     * creates a new game piece with unique color
     *
     * @param color The piece color
     */
    public GamePiece(String color) {
        if (color.equals("red")) {
            this.piece_Color = Color.RED;
        }
        if (color.equals("green")) {
            this.piece_Color = Color.GREEN;
        }
        if (color.equals("yellow")) {
            this.piece_Color = Color.YELLOW;
        }
        if (color.equals("blue")) {
            this.piece_Color = Color.BLUE;
        }
        if (color.equals("orange")) {
            this.piece_Color = Color.ORANGE;
        }
    }

    public String getPieceColor()
    {
        if (this.piece_Color == Color.RED)
            return "red";
        if (this.piece_Color == Color.GREEN)
            return "green";
        if (this.piece_Color == Color.YELLOW)
            return "yellow";
        if (this.piece_Color == Color.BLUE)
            return "blue";
        if (this.piece_Color == Color.ORANGE)
            return "orange";
        return null;
    }
}