public class SnakesAndLaddersGame {
    private Die diegame;
    private int numberOfPlayers;
    private Player[] players;
    private GameBoard board;
    public SnakesAndLaddersGame(int minimum,int maximum){
        this.diegame = new Die(minimum,maximum);
        this.numberOfPlayers = 0;
        this.players = new Player[5];
        this.board = new GameBoard();
    }

    public SnakesAndLaddersGame(){
        this.diegame = new Die();
        this.numberOfPlayers = 0;
        this.players = new Player[5];
        this.board = new GameBoard();
    }

    public void initializeGame(){
       String command = Main.scanner.nextLine();
       while(!(command.equals("end"))) {//haser lehosif tnay shel 2 sahkanim
          String[] commandWords = command.split(" ",4);
          if((commandWords[0]+ " " + commandWords[1]).equals("add player")){
              addPlayer(numberOfPlayers ,commandWords[2] ,commandWords[3]);
              continue;
          }
           if((commandWords[0]+ " " + commandWords[1]).equals("add ladder")){
               addLadder(Integer.parseInt(commandWords[2]),Integer.parseInt(commandWords[3]));
               continue;
           }


           command = Main.scanner.nextLine();
       }
    }
    private void addLadder(int length,int squareNumber) {
        if (squareNumber > 100 || squareNumber < 1) {
            System.out.println("The square is not within the board's boundaries!");
            return;
        }
        if (length + squareNumber > 100) {
            System.out.println("The ladder is too long!");
            return;
        }
        if (findBottomLadder(squareNumber)) {
            System.out.println("This square already contains a bottom of a ladder!");
            return;
        }
        if (findSnakeHead(squareNumber)) {
            System.out.println("This square contains a head of a snake!");
            return;
        }
        board.getSquare(squareNumber).setLadderStart(new Ladder(squareNumber,length));
    }

    private boolean findSnakeHead(int squareNumber){
        Square currentSquare = this.board.getSquare(squareNumber);
        if(currentSquare.getSnakeHead() == null)
            return false;
        return true;
    }

    private boolean findBottomLadder(int squareNumber){
        Square currentSquare = this.board.getSquare(squareNumber);
        if(currentSquare.getLadderStart() == null)
            return false;
        return true;
    }

    private void addPlayer(int numberOfPlayers,String name,String color){
        if(numberOfPlayers >= 5) {
            System.out.println("The maximal number of players is five !");
            return;
        }
        if(!(originalName(name)) && !(originalColor(color))){
            System.out.println("The name and the color are already taken!");
            return;
        }
        if(!(originalName(name))){
            System.out.println("The name is already taken!");
            return;
        }
        if(!(originalColor(color))) {
            System.out.println("The color is already taken!");
            return;
        }
        players[numberOfPlayers] = new Player(name,color);
        this.numberOfPlayers++;
    }
    private boolean originalName(String name){
        for(int i=0;i<5;i++)
        if(players[i]!=null && (players[i].getName()).equals(name))
            return false;
        return true;
    }
    private  boolean originalColor(String color) {
        for(int i=0;i<5;i++)
            if(players[i]!=null && (players[i].getGamePieceColor()).equals(color))
                return false;
        return true;
    }
}
