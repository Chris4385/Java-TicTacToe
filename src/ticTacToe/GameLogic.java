package ticTacToe;

public class GameLogic {
    private Players pair;
    private Player currPlayer;
    private boolean result;
    private Spots game;

    public GameLogic(){
        this.pair = new Players();
        this.game = new Spots();
        this.result = false;
        this.currPlayer = this.pair.getFirstPlayer();

    }

    public void start(Spot move){

        if(game.selectButton(move)){
            this.currPlayer.addSpot(move);
            switchPlayer();

        }



    }

    private void switchPlayer(){

        if(this.currPlayer.equals(this.pair.getSecondPlayer())){
            this.currPlayer = this.pair.getFirstPlayer();
        }else{
            this.currPlayer = this.pair.getSecondPlayer();
        }
    }

    public String currPlayerIdentity(){
        return this.currPlayer.getIdentity();
    }


    public boolean hasGameResult(){
        return game.hasGameEnded() || pair.winnerBorn();
    }

    public String gameResult(){
        while(!game.hasGameEnded()){
            if(pair.winnerBorn())
                return pair.announceWinner();
        }

        return "The End!";
    }
}

