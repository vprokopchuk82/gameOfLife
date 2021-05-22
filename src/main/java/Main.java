import domain.Board;
import domain.Player;
import generate.RandomPopulator;
import rules.GOLRule;



public class Main {
    private final static int rows = 25;
    private final static int columns = 25;

    public static void main(String[] args) {
        Player player = new Player(new Board(new RandomPopulator(rows, columns)), new GOLRule());
        player.nextGen();
    }

}
