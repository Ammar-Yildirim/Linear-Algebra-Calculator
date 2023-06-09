package linear.algebra;

public class GaussianElimination{
    private int rows;
    private int cols;
    private double[][] matrix;
    
    public int getRows(){
        return rows;
    }
    public int getCols(){
        return cols;
    }
    public double[][] getMatrix(){
        return matrix;
    }
    public void setMatrix(double[][] matrix){
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        if(numRows != rows || numCols != cols){
            throw new IllegalArgumentException();
        }
        this.matrix = matrix;
    }

    public GaussianElimination(int rows, int cols, double[][] matrix){
        this.rows = rows;
        this.cols = cols;
        this.matrix = matrix;
    }

    private int argMax(int startingRow, int startingCol) {
        double max = Math.abs(matrix[startingRow][startingCol]);
        int maxRow = startingRow;
        for (int i = startingRow + 1; i < rows; i++) {
            if (Math.abs(matrix[i][startingCol]) > max) {
                max = Math.abs(matrix[i][startingCol]);
                maxRow = i;
            }
        }
        return maxRow;
    }

    private void swapRows(int row1, int row2) {
        double[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }

    public void rowEchelonForm() {
        int h = 0;
        int k = 0;

        while (h < rows && k < cols) {
            int i_max = argMax(h, k);
            if (matrix[i_max][k] == 0) {
                k++;
            } else {
                swapRows(h, i_max);
                for (int i = h + 1; i < rows; i++) {
                    multiplyAndAddRow(i, h, k);
                }
                multiplyRow(h, k);

                h=h+1;
                k=k+1;
            }
        }
    }
    private void multiplyAndAddRow(int addRow, int mulRow, int colIndex) {
        double f = matrix[addRow][colIndex] / matrix[mulRow][colIndex];
        for(int j = colIndex; j<cols ; j++ ){
            matrix[addRow][j] -= matrix[mulRow][j] * f;
        }
    }
    private void multiplyRow(int rowIndex, int colIndex){
        double d = matrix[rowIndex][colIndex];
        for(int j = colIndex; j<cols; j++){
            matrix[rowIndex][j] /= d;
        }
    }
    public void backSubstitution() {
        for (int i = rows - 1; i >= 0; i--) {
            if (matrix[i][i] == 0) {
                throw new IllegalArgumentException("No Unique Solution!");
            }
            for (int j = i - 1; j >= 0; j--) {
                multiplyAndAddRow(j, i, i);
            }
        }
    }
    private void checkMatrixDimensions(double[][] array) {
        //No details about it on canvas
    }

    public void print(){
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols ;j++){
                if(j == 3){
                    System.out.print("=");
                }
                if(matrix[i][j]>=0 && j!=3){
                    System.out.print("+");
                }
                switch(j){
                    case 0:
                        System.out.print(matrix[i][j] +"x");
                        break;
                    case 1:
                        System.out.print(matrix[i][j] +"y");
                        break;
                    case 2:
                        System.out.print(matrix[i][j] +"z");
                        break;
                    case 3:
                        System.out.print(matrix[i][j]);
                        break;
                }
                
            }
            System.out.println();
        }
    }
    public void printMatrix(){
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }    

}