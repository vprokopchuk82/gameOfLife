package domain;

import rules.Rule;

public class Player {
    private final Rule rule;
    private final Board board;

    public Player(Board board, Rule rule) {
        this.board = board;
        this.rule = rule;
    }

    public void nextGen() {
        while (true) {
            try {
                nextGeneration();
                System.out.println(board);
                System.out.println();
                Thread.sleep(500);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }

        }

    }

    private void nextGeneration() {
        Cell[][] cells = board.getCells();
        int rows = cells.length;
        int columns = cells[0].length;
        Cell[][] nextGen = new Cell[rows][columns];
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                Integer neighbourCount = board.getNumOfNeighbours(j, i);
                Cell currentCell = cells[j][i];
                Cell nextCell = rule.checkState(currentCell, neighbourCount);
                nextGen[j][i] = nextCell;
            }
        }
        board.setCells(nextGen);
    }

}
