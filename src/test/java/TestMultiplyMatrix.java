import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TestMultiplyMatrix {


    @Test
    public void multiplication() throws InterruptedException {
        MultiplyMatrix matrixMultiplier = new MultiplyMatrix();
        int[][] firstMatrix = {{1, 2, 3}, {3, 4, 5}};
        int[][] secondMatrix = {{3, 2, 3}, {4, 5, 6}, {1, 0, 0}};
        int[][] actual = {{14, 12, 15}, {30, 26, 33}};
        int[][] result = matrixMultiplier.multiplying(firstMatrix, secondMatrix);

        assertArrayEquals(result, actual);
    }

}