/**
 * В классе осуществляется перемножение двух матриц
 */
public class MultiplyMatrix {

    private final int THREAD_COUNT = 5;

    /**
     * Возвращает результирующую матрицу
     * @param firstMatrix - первая матрица
     * @param secondMatrix - вторая матрица
     * @return - результирующая матрица
     * @throws InterruptedException
     */
    public int[][] multiplying(int[][] firstMatrix, int[][] secondMatrix)  {
        int rows = firstMatrix.length;
        int columns = secondMatrix[0].length;
        int[][] resultMatrix = new int[rows][columns];

        int count = (rows * columns) / THREAD_COUNT;
        MyThread[] threads = new MyThread[THREAD_COUNT];
        int firstIndex = 0;
        int lastIndex;

        for (int i = 0; i < THREAD_COUNT; i++) {
            lastIndex = firstIndex + count;

            if (i == THREAD_COUNT - 1 && lastIndex < rows * columns) {
                lastIndex = rows * columns;
            }

            threads[i] = new MyThread(firstMatrix, secondMatrix, resultMatrix, firstIndex, lastIndex);
            threads[i].start();
            firstIndex = lastIndex;
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        return resultMatrix;
    }
}