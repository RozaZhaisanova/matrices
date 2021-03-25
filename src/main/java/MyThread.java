/**
 * Поток, получающий часть результирующей матрицы
 */
public class MyThread extends java.lang.Thread {

    private int[][] firstMatrix;
    private int[][] secondMatrix;
    private int[][] resultMatrix;
    private int firstIndex;
    private int lastIndex;

    public MyThread(int[][] firstMatrix, int[][] secondMatrix, int[][] resultMatrix, int firstIndex, int lastIndex) {
        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;
        this.resultMatrix = resultMatrix;
        this.firstIndex = firstIndex;
        this.lastIndex = lastIndex;
    }


    @Override
    public void run() {
        for (int i = firstIndex; i < lastIndex; i++) {
            int row = i / resultMatrix[0].length;
            int col = i % resultMatrix[0].length;
            calculateCell(row, col);
        }
    }

    /**
     * Метод вычисляет ячейку в результирующей матрице
     * @param row
     * @param col
     */
    private void calculateCell(int row, int col) {
        for (int i = 0; i < firstMatrix[0].length; i++) {
            resultMatrix[row][col] += firstMatrix[row][i] * secondMatrix[i][col];
        }
    }
}