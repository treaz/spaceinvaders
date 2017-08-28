package com.horiaconstantin.invaders;

import java.util.Arrays;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class MatrixUtils {


    /**
     * Helper method that returns a matrix with the specified params
     * @param numberofRows minimum 1, else exception will be thrown
     * @param numberOfColumns minimum 1, else exception will be thrown
     * @param defaultValue any non-empty string, else exception will be thrown
     * @throws IllegalArgumentException if any of the arguments is out of bounds
     */
    public static String[][] getEmptyMatrix(int numberofRows, int numberOfColumns, String defaultValue){

        if(numberOfColumns < 1 || numberofRows <1 || isBlank(defaultValue)){
            throw new IllegalArgumentException("Cannot create a new empty matrix with the given arguments");
        }

        String[][] radarImage = new String[numberofRows][numberOfColumns];
        for (int i = 0; i < numberofRows; i++) {
            String[] row = new String[numberOfColumns];
            Arrays.fill(row, defaultValue);
            radarImage[i] = row;
        }

        return radarImage;
    }

    /**
     *
     * @return a new matrix that contains the
     */
//    public static String[][] insertMatrixAtPosition(String[][] originalMatrix, int startRow, int startColumn, String[][] matrixToInsert){
        //check inputs; check that the matrix can be inserted entirely in the existing matrix

//        Arrays.copyOf(originalMatrix)


//    }



}
