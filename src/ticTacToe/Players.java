package ticTacToe;

public class Players {
    private Player[] pair;

    public Players(){
        this.pair = new Player[2];
        this.pair[0] = new Player("X");
        this.pair[1] = new Player("O");
    }

    public Player getFirstPlayer(){
        return this.pair[0];
    }

    public Player getSecondPlayer(){
        return this.pair[1];
    }


    public boolean winnerBorn(){
        Player first = this.getFirstPlayer();
        Player second = this.getSecondPlayer();
        return first.hasWon() || second.hasWon();
    }

    public String announceWinner(){
        Player first = this.getFirstPlayer();
        Player second = this.getSecondPlayer();
        if(first.hasWon())
            return "Winner: Player X";
        if(second.hasWon())
            return "Winner: Player 0";

        return "Draw!";
    }




}
