package ticTacToe;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Gan
 */
public class Player {
    private final String identity;
    private Map<String,List<Spot>> result;

    public Player(String identity){
        this.identity = identity;
        this.result = new HashMap<>();
        initializeHashMap();
    }

    private void initializeHashMap(){
        result.put("first row", new ArrayList<>());
        result.put("second row", new ArrayList<>());
        result.put("third row", new ArrayList<>());

        result.put("first column", new ArrayList<>());
        result.put("second column", new ArrayList<>());
        result.put("third column", new ArrayList<>());

        result.put("left diagonal", new ArrayList<>());
        result.put("right diagonal", new ArrayList<>());


    }

    public String getIdentity(){
        return this.identity;
    }



    public void addSpot(Spot selected){

        addDiagonalSpot(selected);

        if(selected.getRow() == 0){
            result.get("first row").add(selected);

        }else if(selected.getRow() == 1){
            result.get("second row").add(selected);
        }else if(selected.getRow() == 2){
            result.get("third row").add(selected);
        }

        if(selected.getColumn() == 0){
            result.get("first column").add(selected);
        }else if(selected.getColumn() == 1){
            result.get("second column").add(selected);
        }else if(selected.getColumn() == 2){
            result.get("third column").add(selected);
        }


    }

    private void addDiagonalSpot(Spot selected){
        if(selected.getColumn() == selected.getRow())
            result.get("left diagonal").add(selected);

        if(selected.getColumn() + selected.getRow() == 2)
            result.get("right diagonal").add(selected);
    }

    public boolean hasWon(){
        for(String key: result.keySet()){
            if(result.get(key).size() >= 3)
                return true;
        }
        return false;
    }





}
