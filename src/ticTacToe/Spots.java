package ticTacToe;

import java.util.ArrayList;
import java.util.List;

public class Spots {
    private List<Spot> availableSpot;
    private List<Spot> selectedSpot;

    public Spots(){
        this.availableSpot = new ArrayList<>();
        this.selectedSpot = new ArrayList<>();
        initializeAvailableSpots();
    }

    public List<Spot> getAvailableSpot(){
        return this.availableSpot;
    }
    public List<Spot> getSelectedSpot(){
        return this.selectedSpot;
    }

    private void initializeAvailableSpots(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                availableSpot.add(new Spot(i, j));
            }
        }
    }
    public boolean spotAvailable(Spot selected){
        for(Spot item: availableSpot){
            if(item.equals(selected))
                return true;
        }
        return false;
    }
    public boolean selectButton(Spot selected){
        if(!isButtonSelected(selected) ){
            availableSpot.remove(selected);
            selectedSpot.add(selected);
            return true;
        }
        return false;
    }

    private boolean isButtonSelected(Spot spot){
        for(Spot item: selectedSpot){
            if(item.equals(spot))
                return true;
        }
        return false;
    }

    public boolean hasGameEnded(){
        return this.selectedSpot.size() == 9;
    }


}

