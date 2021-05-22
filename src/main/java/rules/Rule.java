package rules;

import domain.Cell;

public interface Rule {


    Cell checkState(Cell cell, Integer numOfNeighbours);
}
