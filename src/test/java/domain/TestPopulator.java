package domain;

import generate.Populator;

public class TestPopulator implements Populator {
    @Override
    public Cell[][] populate() {
        return new Cell[][]{
                {new DeadCell(), new AliveCell(), new AliveCell(), new AliveCell()},
                {new AliveCell(), new DeadCell(), new AliveCell(), new DeadCell()},
                {new DeadCell(), new AliveCell(), new AliveCell(), new DeadCell()},
                {new AliveCell(), new DeadCell(), new AliveCell(), new DeadCell()},
        };
    }
}
