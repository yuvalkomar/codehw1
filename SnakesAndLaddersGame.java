public class SnakesAndLaddersGame {
    private Die dieGame;
    private int numberOfPlayers;
    private Player[] players;
    private GameBoard board;
    public SnakesAndLaddersGame(int minimum,int maximum){
        this.dieGame = new Die(minimum,maximum);
        this.numberOfPlayers = 0;
        this.players = new Player[5];
        this.board = new GameBoard();
    }

    public SnakesAndLaddersGame(){
        this.dieGame = new Die();
        this.numberOfPlayers = 0;
        this.players = new Player[5];
        this.board = new GameBoard();
    }

    public void initializeGame(){
       System.out.println("Initializing the game...");
       String command = Main.scanner.nextLine();
       boolean initializing = true;
          while(initializing) {
          if(command.equals("end")){
              if(players[1]!=null)
                  initializing = false;
              else {
                  System.out.println("Cannot start the game, there are less than two players!");
                  command = Main.scanner.nextLine();
              }
              continue;
          }
          String[] commandWords = command.split(" ",4);
          if((commandWords[0]+ " " + commandWords[1]).equals("add player")){
              addPlayer(numberOfPlayers ,commandWords[2] ,commandWords[3]);
              continue;
          }
          if((commandWords[0]+ " " + commandWords[1]).equals("add ladder")){
               addLadder(Integer.parseInt(commandWords[2]),Integer.parseInt(commandWords[3]));
               continue;
          }
          if((commandWords[0]+ " " + commandWords[1]).equals("add snake")){
              addSnake(Integer.parseInt(commandWords[2]),Integer.parseInt(commandWords[3]));
              continue;
          }

           command = Main.scanner.nextLine();
       }
    }

    private void addSnake(int length,int squareNumber){
        if (squareNumber > 100 || squareNumber < 1) {
            System.out.println("The square is not within the board's boundaries!");
            return;
        }
        if (squareNumber == 100) {
            System.out.println("You cannot add a snake in the last square!");
            return;
        }
        if (squareNumber-length<1) {
            System.out.println("The snake is too long!");
            return;
        }
        if (findSnakeHead(squareNumber)) {
            System.out.println("This square already contains a head of a snake !");
            return;
        }
        if (findBottomLadder(squareNumber)) {
            System.out.println("This square contains a bottom of a ladder !");
            return;
        }
        board.getSquare(squareNumber).setSnakeHead(new Snake(squareNumber,length));
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

    /**
     *
     * @return
     */
    public String start(){
        int roundNumber = 0;
        String playerPath;
        Player winner = null;
        while(winner == null) {
            System.out.println("------------------------- Round number " + roundNumber + " -------------------------");
            for(int i = 0; i <= numberOfPlayers-1; i++) {
                playerPath = players[i].getSquareNum() + " -> ";
                int roll = dieGame.roll();
                players[i].moveSquareNum(roll);
                playerPath = playerPath + players[i].getSquareNum();
                boolean freeSquare = false;
                while(!(freeSquare)) {
                    Snake checkSnake = board.getSnakeHead(players[i].getSquareNum());
                    if (checkSnake != null) {
                        players[i].moveSquareNum(checkSnake.getSnakeLength());
                        playerPath = playerPath + " -> " + players[i].getSquareNum();
                    }
                    Ladder checkLadder = board.getLadderStart(players[i].getSquareNum());
                    if (checkLadder != null) {
                        players[i].moveSquareNum(checkLadder.getLadderLength());
                        playerPath = playerPath + " -> " + players[i].getSquareNum();
                    }
                    if(checkSnake == null && checkLadder == null)
                        freeSquare = true;
                    if(players[i].getSquareNum() == 100)
                        winner = players[i];

                }
                System.out.println(players[i].getName() + " rolled " + roll +
                        ". The path to the next square: " + playerPath);
            }
            System.out.println("board the on positions Players:");
            for(int i = 0; i <= numberOfPlayers-1; i++) {
                System.out.println(players[i].getName() + " is in square number " + players[i].getSquareNum());
            }
            roundNumber++;
        }
        return winner.getName();
    }
}
