package com.horiaconstantin.invaders;

import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

public class MatrixUtils {

    /**
     * Helper method that returns a matrix with the specified params
     * @param numberofRows minimum 1, else exception will be thrown
     * @param numberOfColumns minimum 1, else exception will be thrown
     * @param defaultValue any non-empty string, else exception will be thrown
     * @throws IllegalArgumentException if any of the arguments is out of bounds
     */


    /**
     * Helper method that returns a matrix with the specified params
     *
     * @param rowDimension Number of rows in the new matrix.
     * @param columnDimension Number of columns in the new matrix.
     * @throws NotStrictlyPositiveException if the row or column dimension is
     * not positive.
     */
    public static String[][] getEmptyMatrix(int rowDimension, int columnDimension){
        RealMatrix emptyMatrix = new Array2DRowRealMatrix(rowDimension, columnDimension);

        return realMatrixToStringMatrix(emptyMatrix);
    }

    public static RealMatrix stringMatrixToRealMatrix(String[][] radarImage){
        double[][] radarImageAsNumbers = new double[radarImage.length][radarImage[0].length];
        for (int i = 0; i<radarImage.length; i++){
            for (int j = 0; j<radarImage[0].length; j++){
                radarImageAsNumbers[i][j] = ("-".equals(radarImage[i][j]) ? 0 : 1);
            }
        }

        return new Array2DRowRealMatrix(radarImageAsNumbers);
    }

    public static String[][] realMatrixToStringMatrix(RealMatrix radarImageMartix){
        double[][] radarImageAsNumbers = radarImageMartix.getData();

        String[][] radarImage = new String[radarImageAsNumbers.length][radarImageAsNumbers[0].length];
        for (int i = 0; i<radarImageAsNumbers.length; i++){
            for (int j = 0; j<radarImageAsNumbers[0].length; j++){
                radarImage[i][j] = (0 == radarImageAsNumbers[i][j] ? "-" : "o");
            }
        }

        return radarImage;
    }

}
