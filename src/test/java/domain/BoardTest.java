package domain;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BoardTest {

    @Test
    public void getNumOfNeighboursTest() throws Exception{
        Board board = new Board(new TestPopulator());
        Integer numOfNeighbours = board.getNumOfNeighbours(2, 2);
        Assert.assertEquals(3, numOfNeighbours.longValue());


    }


}