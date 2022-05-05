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
            piece_Color = Color.RED;
        }
        if (color.equals("green")) {
            piece_Color = Color.GREEN;
        }
        if (color.equals("yellow")) {
            piece_Color = Color.YELLOW;
        }
        if (color.equals("blue")) {
            piece_Color = Color.BLUE;
        }
        if (color.equals("orange")) {
            piece_Color = Color.ORANGE;
        }
    }
}