package ticTacToe;

public class Spot {
    private int row;
    private int col;


    public Spot(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int getRow(){
        return this.row;
    }

    public int getColumn(){
        return this.col;
    }

    @Override
    public String toString(){
        return "The coordinate for this spot is: (" + this.getRow() + ", " + this.getColumn() + ")";
    }

    @Override
    public boolean equals(Object spotGiven){
        if(spotGiven == this)
            return true;

        if(!(spotGiven instanceof Spot))
            return false;

        Spot compared = (Spot)spotGiven;
        if(this.getRow() == compared.getRow() && this.getColumn() == compared.getColumn()){
            return true;
        }


        return false;
    }

}
