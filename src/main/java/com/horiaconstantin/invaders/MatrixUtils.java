package com.horiaconstantin.invaders;

import lombok.NonNull;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

/**
 * Class that contains all kind of utilities for matrix manipulation specific to this app
 */
public class MatrixUtils {

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

    /**
     * Transforms a String[][] into a RealMatrix
     * @param stringMatrix a non-null matrix that has only "o" or "-" as values
     * @return a RealMatrix that has 0 in the positions in which stringMatrix has "-" and "1" in the positions in which it has "o"
     * @throws IllegalArgumentException if argument contains other values than "o" or "-"
     * @throws NullPointerException if argument is null
     */
    public static RealMatrix stringMatrixToRealMatrix(String[][] stringMatrix){
        validateValues(stringMatrix);

        double[][] radarImageAsNumbers = new double[stringMatrix.length][stringMatrix[0].length];
        for (int i = 0; i<stringMatrix.length; i++){
            for (int j = 0; j<stringMatrix[0].length; j++){
                radarImageAsNumbers[i][j] = ("-".equals(stringMatrix[i][j]) ? 0 : 1);
            }
        }

        return new Array2DRowRealMatrix(radarImageAsNumbers);
    }

    /**
     * Validates is the argument contains valid values: "o" or "-"
     * @param stringMatrix
     */
    public static void validateValues(@NonNull String[][] stringMatrix) {
        for (String[] row : stringMatrix) {
            for (String value : row) {
                if (!"-".equals(value) && !"o".equals(value)){
                    throw new IllegalArgumentException("Radar image contains invalid characters");
                }
            }
        }
    }

    //TODO javadoc this
    public static String[][] realMatrixToStringMatrix(@NonNull RealMatrix doubleMatrix){
        //TODO validate values
        double[][] radarImageAsNumbers = doubleMatrix.getData();

        String[][] radarImage = new String[radarImageAsNumbers.length][radarImageAsNumbers[0].length];
        for (int i = 0; i<radarImageAsNumbers.length; i++){
            for (int j = 0; j<radarImageAsNumbers[0].length; j++){
                radarImage[i][j] = (0 == radarImageAsNumbers[i][j] ? "-" : "o");
            }
        }

        return radarImage;
    }

}
