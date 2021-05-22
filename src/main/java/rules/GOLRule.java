package rules;

import domain.AliveCell;
import domain.Cell;
import domain.DeadCell;

import java.util.HashMap;
import java.util.Map;

public class GOLRule implements Rule {

    @Override
    public Cell checkState(Cell cell, Integer numOfNeighbours) {
        if (cell.isAlive()&&numOfNeighbours<2){
            return new DeadCell();
        }
        else if (cell.isAlive()&&(numOfNeighbours==2||numOfNeighbours==3)){
            return new AliveCell();
        }
        else if (cell.isAlive()&&numOfNeighbours>3){
            return new DeadCell();
        }
        else if (!cell.isAlive() && numOfNeighbours==3){
            return new AliveCell();
        }
        else return new DeadCell();
        
        
        


    }
}
