package domain;

public class DeadCell implements Cell {
    public DeadCell() {
    }

    @Override
    public Boolean isAlive() {
        return false;
    }

    @Override
    public String toString() {
        return "0";
    }

}
