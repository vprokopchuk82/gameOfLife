package domain;

import domain.exception.InvalidCellsException;
import generate.Populator;

import java.util.Arrays;
import java.util.Objects;

public class Board {
    private final Integer rows;
    private final Integer columns;

    private Cell[][] cells;

    public Board(Populator populator) {
        this(populator.populate());
    }

    private Board(Cell[][] cells) {
        if (cells == null)
            throw new InvalidCellsException("Invalid number of cells");
        this.cells = cells;
        this.rows = this.cells.length;
        this.columns = this.cells[0].length;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;

    }


    public Integer getNumOfNeighbours(Integer row, Integer column) {
        int rowLimit = cells.length - 1;
        int columnLimit = cells[0].length - 1;
        int count = 0;
        for (int x = Math.max(0, row - 1); x <= Math.min(row + 1, rowLimit); x++) {
            for (int y = Math.max(0, column - 1); y <= Math.min(column + 1, columnLimit); y++) {
                if (x != row || y != column) {
                    count += checkIfNeighbourIsAlive(cells[x][y]);
                }
            }
        }
        return count;
    }


    private Integer checkIfNeighbourIsAlive(Cell cell) {
        return cell.isAlive() ? 1 : 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Cell[] cell : cells) {
            for (Cell value : cell) {
                sb.append(value.toString()).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Objects.equals(rows, board.rows) &&
                Objects.equals(columns, board.columns) &&
                Arrays.equals(cells, board.cells);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(rows, columns);
        result = 31 * result + Arrays.hashCode(cells);
        return result;
    }

    public Cell[][] getCells() {
        return cells;
    }
}
