package generate;

import domain.AliveCell;
import domain.Cell;
import domain.DeadCell;

import java.security.SecureRandom;

public class RandomPopulator implements Populator{
    private final int rows;
    private final int columns;
    private final SecureRandom random;

    public RandomPopulator(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        random = new SecureRandom();
    }


    @Override
    public Cell[][] populate() {
        Cell[][] cells = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cells[i][j] = random.nextBoolean() ? new AliveCell() : new DeadCell();
            }
        }
        return cells;
    }
}
