public class SnakesAndLaddersGame {
    private Die diegame;
    private int numberOfPlayers;
    private Player[] players;
    public SnakesAndLaddersGame(int minimum,int maximum){
        this.diegame = new Die(minimum,maximum);
        this.numberOfPlayers = 0;
        this.players = new Player[5];
    }

    public SnakesAndLaddersGame(){
        this.diegame = new Die();
        this.numberOfPlayers = 0;
        this.players = new Player[5];
    }

    public void initializeGame(){
       String command = Main.scanner.nextLine();
       while(!(command.equals("end"))) {//haser lehosif tnay shel 2 sahkanim
          String[] commandWords = command.split(" ",4);
          if((commandWords[0]+ " " + commandWords[1]).equals("add player")){
              if(numberOfPlayers >= 5) {
                  System.out.println("The maximal number of players is five !");
                  continue;
              }
              if(originalName(commandWords[2])){

              }
          }


           command = Main.scanner.nextLine();
       }
    }
    private boolean originalName(String name){

    }
}
