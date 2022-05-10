public class Ladder {
    int ladderLength;
    int squareNumber;

    public Ladder(int ladderPosition, int length){
        this.squareNumber = ladderPosition;
        this.ladderLength = length;
    }
    public int getLadderLength(){
        return this.ladderLength;
    }
}
